package com.tmobile.retailinventoryserialization.command.device.service;

import javax.validation.Valid;

import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;

public interface DeviceCommandService {
	public String addDevice(@Valid Device device);
	public String updateDevice(String imei, @Valid Device updatedDevice);
}
