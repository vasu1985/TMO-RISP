
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
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseResponse;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRestRequest;
import com.tmobile.retailinventoryserialization.command.device.CommandApp;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Transaction;
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
@CrossOrigin("*")
@RestController
@RequestMapping("/device")
public class DeviceCommandController extends DeviceBaseController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(DeviceCommandController.class);

	/** The device service. */
	@Autowired
	private DeviceCommandService deviceCommandService;

	@Autowired
	private TransactionsCommandService transactionsCommandService;

	ApplicationContext context;

	ObjectMapper mapper = new ObjectMapper();

	/**
	 * Adds the device.
	 *
	 * @param device
	 *            the device
	 * @return the string
	 */
	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.POST)
	public BaseResponse addDevice(@RequestBody BaseRestRequest<Device> restRequest) {
		Device device = null;
		if (null != restRequest && null != restRequest.getRequest()) {
			device = restRequest.getRequest();

		} else {
			log.error("device obj not sent");
		}
		return deviceCommandService.addDevice(device);
	}

	@Autowired
	public void context(ApplicationContext context) {
		this.context = context;
	}

	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.GET)
	public BaseResponse getDeviceDetails(@PathVariable String imei) {
		// GetDeviceRequest getDeviceRequest = restRequest.getRequest();
		// log.info(getDeviceRequest.getAdditionaDetails());
		return deviceCommandService.getDeviceDetails(imei);
	}

	/**
	 * Update device.
	 *
	 * @param imei
	 *            the imei
	 * @param restRequest
	 *            the device
	 * @return the string
	 */
	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.PUT)
	public BaseResponse updateDevice(@PathVariable String imei, @RequestBody BaseRestRequest<Device> restRequest) {
		log.info("Updating Device...");
		String status = "success";
		Device device = null;
		BaseResponse response = null;
		try {
			RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
			rabbitTemplate.setQueue(CommandApp.queueName);
			if (null != restRequest && null != restRequest.getRequest()) {
				device = restRequest.getRequest();

			} else {
				log.error("device obj not sent");
			}
			response = deviceCommandService.updateDevice(imei, device);
			rabbitTemplate.convertAndSend(CommandApp.queueName, mapper.writeValueAsString(restRequest));
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

				transactionsCommandService.addTransaction(trans);
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
		return response;
	}
}
