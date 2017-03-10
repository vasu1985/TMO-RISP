
package com.tmobile.retailinventorycommandservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	private  RabbitTemplate mRabbitTemplate = new RabbitTemplate(connectionFactory());

	private  ConfigurableApplicationContext mContext;

	public DeviceCommandController() {
	}
	@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
	public DeviceCommandController(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {

		this.mRabbitTemplate = rabbitTemplate;
		this.mContext = context;
	}

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(DeviceCommandController.class);

	/** The device service. */
	@Autowired
	private DeviceCommandService deviceCommandService;

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
		mRabbitTemplate.convertAndSend(CommandApp.queueName, "Hello from RabbitMQ!");
		return deviceCommandService.updateDevice(device);
	}
}
