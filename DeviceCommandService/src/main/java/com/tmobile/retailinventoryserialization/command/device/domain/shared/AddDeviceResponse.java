package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.tmobile.magenta.base.domain.shared.BaseRequest;

public class AddDeviceResponse implements BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
