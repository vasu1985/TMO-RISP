
package com.tmobile.retailinventoryserialization.command.device.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmobile.retailinventoryserialization.command.device.CommandApp;
import com.tmobile.retailinventoryserialization.command.device.domain.Device;
import com.tmobile.retailinventoryserialization.command.device.domain.Transaction;
import com.tmobile.retailinventoryserialization.command.device.service.DeviceCommandService;
import com.tmobile.retailinventoryserialization.command.device.service.TransactionsCommandService;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS DeviceController
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:30:01 PM Author: SS00443175
 */
@CrossOrigin( "*")
@RestController
@RequestMapping( "/device")
public class DeviceCommandController {

    /** The log. */
    private static Logger              log    = LoggerFactory.getLogger(DeviceCommandController.class);

    /** The device service. */
    @Autowired
    private DeviceCommandService       deviceCommandService;

    @Autowired
    private TransactionsCommandService transactionsCommandService;

    ApplicationContext                 context;

    ObjectMapper                       mapper = new ObjectMapper();

    /**
     * Adds the device.
     *
     * @param device
     *            the device
     * @return the string
     */
    @RequestMapping( value = "/tmo/resources/services/devices", method = RequestMethod.POST)
    public String addDevice( @RequestBody Device device) {
        log.info("Controller ----------------" + device.getImei());
        return deviceCommandService.addDevice(device);
    }

    @Autowired
    public void context( ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping( value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.GET)
    public Device getDeviceDetails( @PathVariable String imei) {
        return deviceCommandService.getDeviceDetails(imei);
    }

    /**
     * Update device.
     *
     * @param imei
     *            the imei
     * @param device
     *            the device
     * @return the string
     */
    @RequestMapping( value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.PUT)
    public String updateDevice( @RequestBody Device device) {
        log.info("Updating Device...");
        String updateMesg = null;
        String status = "success";
        try {
            RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
            rabbitTemplate.setQueue(CommandApp.queueName);
            updateMesg = deviceCommandService.updateDevice(device);
            rabbitTemplate.convertAndSend(CommandApp.queueName, mapper.writeValueAsString(device));
        } catch (AmqpException e) {
            log.error(e.toString());
            status = "fail";

        } catch (JsonProcessingException e) {
            log.error(e.toString());
            status = "fail";
            e.printStackTrace();

        } catch (Exception e) {
            log.error(e.toString());
            status = "fail";
            throw e;
        } finally {
            try {
                Transaction trans = new Transaction();
                trans.setmImei(device.getImei());
                trans.setmCurrentState(device.getState());
                trans.setmReason(device.getReason());
                trans.setmRepId(device.getRepId());
                trans.setmStatus(status);
                trans.setQueueName(CommandApp.queueName);

                updateMesg = transactionsCommandService.addTransaction(trans);
                log.debug("Transaction imei:" + transactionsCommandService.getTransactionDetails(device.getImei()));

                if (status.equalsIgnoreCase("success")) {
                    RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
                    rabbitTemplate.setQueue(CommandApp.transQueueName);
                    log.debug("Queue name is:" + CommandApp.transQueueName);
                    rabbitTemplate.convertAndSend(CommandApp.transQueueName, mapper.writeValueAsString(trans));
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return updateMesg;
    }
}
