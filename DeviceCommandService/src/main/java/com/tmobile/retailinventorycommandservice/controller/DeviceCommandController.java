
package com.tmobile.retailinventorycommandservice.controller;

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
@CrossOrigin("*")
@RestController
@RequestMapping("/device")
public class DeviceCommandController {

	/** The device service. */
	@Autowired
	private DeviceCommandService deviceCommandService;
	ApplicationContext context;
	
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	public void context(ApplicationContext context) {
		this.context = context;
	}

	/**
	 * Adds the device.
	 *
	 * @param device
	 *            the device
	 * @return the string
	 */
	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.POST)
	public String addDevice(@RequestBody Device device) {
		System.out.println("Controller ----------------"+device.toString());
		return deviceCommandService.addDevice(device);
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
	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.PUT)
	public String updateDevice(@RequestBody Device device) {
		System.out.println("Updating Device...");
		RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		rabbitTemplate.setQueue(CommandApp.queueName);
		try {
			rabbitTemplate.convertAndSend(CommandApp.queueName,mapper.writeValueAsString(device));
		} catch (AmqpException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return deviceCommandService.updateDevice(device);
	}
	
	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.GET)
	public Device getDeviceDetails(@PathVariable String imei) {
		return deviceCommandService.getDeviceDetails(imei);
	}
}
