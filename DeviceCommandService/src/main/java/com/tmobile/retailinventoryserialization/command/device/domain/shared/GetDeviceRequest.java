package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRequest;

public class GetDeviceRequest implements BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("additionaDetails")
	private String mAdditionaDetails;

	public String getAdditionaDetails() {
		return mAdditionaDetails;
	}

	public void setSourceSystem(String pAdditionaDetails) {
		this.mAdditionaDetails = pAdditionaDetails;
	}

}
