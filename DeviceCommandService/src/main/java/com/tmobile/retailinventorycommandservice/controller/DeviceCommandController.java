
package com.tmobile.retailinventorycommandservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmobile.retailinventorycommandservice.CommandApp;
import com.tmobile.retailinventorycommandservice.domain.Device;
import com.tmobile.retailinventorycommandservice.service.DeviceCommandService;

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
    private static Logger        log    = LoggerFactory.getLogger(DeviceCommandController.class);

    /** The device service. */
    @Autowired
    private DeviceCommandService deviceCommandService;

    /** The context. */
    ApplicationContext           context;

    /** The mapper. */
    ObjectMapper                 mapper = new ObjectMapper();

    /**
     * Context.
     *
     * @param context
     *            the context
     */
    @Autowired
    public void context( ApplicationContext context) {
        this.context = context;
    }

    /**
     * Adds the device.
     *
     * @param device
     *            the device
     * @return the string
     */
    @RequestMapping( value = "/tmo/resources/services/devices", method = RequestMethod.POST)
    public String addDevice( @RequestBody Device device) {
        log.info("Controller ----------------" + device.toString());
        return deviceCommandService.addDevice(device);
    }

    /**
     * Update device.
     *
     * @param device
     *            the device
     * @return the string
     */
    @RequestMapping( value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.PUT)
    public String updateDevice( @RequestBody Device device) {
        log.info("Updating Device...");
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        rabbitTemplate.setQueue(CommandApp.queueName);
        try {
            rabbitTemplate.convertAndSend(CommandApp.queueName, mapper.writeValueAsString(device));
        } catch (AmqpException | JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return deviceCommandService.updateDevice(device);
    }
}
