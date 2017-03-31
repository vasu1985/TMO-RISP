package com.tmobile.retailinventoryserialization.command.device.service;

import javax.validation.Valid;

import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;

public interface DeviceCommandService {
	String addDevice(@Valid Device device);
	String updateDevice(String imei, @Valid Device updatedDevice);
	Device getDeviceDetails(String imei);
}
