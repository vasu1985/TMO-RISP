package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmobile.magenta.base.domain.shared.BaseRequest;

public class GetDeviceRequest implements BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("imei")
	private String mImei;
	@JsonProperty("additionaDetails")
	private String mAdditionaDetails;

	public String getAdditionaDetails() {
		return mAdditionaDetails;
	}

	public void setSourceSystem(String pAdditionaDetails) {
		this.mAdditionaDetails = pAdditionaDetails;
	}

	public String getImei() {
		return mImei;
	}

	public void setImei(String pImei) {
		this.mImei = pImei;
	}

}
