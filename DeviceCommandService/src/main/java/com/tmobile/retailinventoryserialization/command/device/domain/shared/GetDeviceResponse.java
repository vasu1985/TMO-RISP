package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseResponse;

public class GetDeviceResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
	private Device device;

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
