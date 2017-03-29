
package com.tmobile.retailinventoryserialization.query.device.controller;

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

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceRequest;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.query.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.query.device.service.DeviceQueryService;

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
	public BaseServiceResponse<List<Device>> getDevices() {
		log.info("Showing devices");
		BaseServiceResponse<List<Device>> response = new BaseServiceResponse<>();
		response.setResult(deviceQueryService.getDevices());
		return response;
	}

	/**
	 * Gets the device details.
	 *
	 * @param imei
	 *            the imei
	 * @return the device details
	 */
	@RequestMapping(value = "${retailInventoryQueryService.imeiDetails.mapping}", method = RequestMethod.GET)
	public BaseServiceResponse<Device> getDeviceDetails(@PathVariable String imei) {
		BaseServiceResponse<Device> response = new BaseServiceResponse<>();
		response.setResult(deviceQueryService.getDeviceDetails(imei));
		return response;
	}

	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.POST)
	public BaseServiceResponse<String> addDevice(@RequestBody BaseServiceRequest<Device> restRequest) {
		Device device = null;
		if (null != restRequest && null != restRequest.getRequest()) {
			device = restRequest.getRequest();
		}
		// TODO if client request is null, need to handle it
		BaseServiceResponse<String> response = new BaseServiceResponse<>();
		response.setResult(deviceQueryService.addDevice(device));
		return response;
	}

	@RequestMapping(value = "retailInventoryQueryService.imeiDetails.mapping", method = RequestMethod.PUT)
	public String updateDevice(@RequestBody Device device) {
		log.info("Updating Device...");

		return deviceQueryService.updateDevice(device);
	}
}
