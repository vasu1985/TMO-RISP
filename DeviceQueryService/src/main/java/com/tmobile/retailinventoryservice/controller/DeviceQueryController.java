
package com.tmobile.retailinventoryservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.retailinventoryservice.domain.Device;
import com.tmobile.retailinventoryservice.service.DeviceQueryService;

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
@RequestMapping("${device.service.mapping}")
public class DeviceQueryController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(DeviceQueryController.class);

	/** The device service. */
	@Autowired
	private DeviceQueryService deviceQueryService;

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	@RequestMapping(value = "${retailInventoryQueryService.allImeiDetails.mapping}", method = RequestMethod.GET)
	public List<Device> getDevices() {
		log.info("Showing devices");
		return deviceQueryService.getDevices();
	}

	/**
	 * Gets the device details.
	 *
	 * @param imei
	 *            the imei
	 * @return the device details
	 */
	@RequestMapping(value = "${retailInventoryQueryService.imeiDetails.mapping}", method = RequestMethod.GET)
	public Device getDeviceDetails(@PathVariable String imei) {
		return deviceQueryService.getDeviceDetails(imei);
	}

	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.POST)
	public String addDevice(@RequestBody Device device) {

		return deviceQueryService.addDevice(device);
	}

	@RequestMapping(value = "retailInventoryQueryService.imeiDetails.mapping", method = RequestMethod.PUT)
	public String updateDevice(@RequestBody Device device) {
		log.info("Updating Device...");

		return deviceQueryService.updateDevice(device);
	}
}
