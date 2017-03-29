package com.tmobile.retailinventoryserialization.query.device.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRequest;

public class Label implements BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Device device;
	/** The rep id. */
	@JsonProperty("repId")
	private String mRepId;
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public String getRepId() {
		return mRepId;
	}
	public void setRepId(String mRepId) {
		this.mRepId = mRepId;
	}

}
