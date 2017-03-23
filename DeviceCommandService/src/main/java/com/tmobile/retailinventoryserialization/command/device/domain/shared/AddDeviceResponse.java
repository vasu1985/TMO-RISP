package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRequestInterface;

public class AddDeviceResponse implements BaseRequestInterface {
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
