package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRequestInterface;

public class GetDeviceResponse implements BaseRequestInterface {
	private static final long serialVersionUID = 1L;
	private Device device;

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
