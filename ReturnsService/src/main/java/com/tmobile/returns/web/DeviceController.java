package com.tmobile.returns.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.returns.domain.Device;
import com.tmobile.returns.service.DeviceService;

@CrossOrigin("*")
@RestController
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.POST)
	public String addDevice(@RequestBody Device device) {
		return deviceService.addDevice(device);
	}

	@RequestMapping(value = "/tmo/resources/services/devices", method = RequestMethod.GET)
	public List<Device> getDevices() {
		return deviceService.getDevices();
	}

	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.GET)
	public Device getDeviceDetails(@PathVariable String imei) {
		return deviceService.getDeviceDetails(imei);
	}

	@RequestMapping(value = "/tmo/resources/services/devices/{imei}", method = RequestMethod.PUT)
	public String updateDevice(@PathVariable String imei, @RequestBody Device device) {
		return deviceService.updateDevice(imei, device);
	}
}
