
package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseRequest;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS Device
 * </p>
 * .
 *
 * @author Arun Kishor
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:28:41 PM Author: SS00443175
 */
@Region("devices")
public class Device implements BaseRequest {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The imei. */
	@Id
	@JsonProperty("imei")
	@NotNull
	@Size(min = 15, max = 15)
	private String mImei;

	/** The programId */
	@JsonProperty("programId")
	private String mProgramId;

	/** The state. */
	@JsonProperty("state")
	@NotNull
	private String mState;

	/** The reason. */
	@JsonProperty("reason")
	@NotNull
	private String mReason;

	/** The reason. */
	@JsonProperty("repId")
	private String mRepId;

	public Device() {

	}

	public Device(String pImei, String pProgramId, String pState, String pReason, String pRepId) {
		super();
		this.mImei = pImei;
		this.mProgramId = pProgramId;
		this.mState = pState;
		this.mReason = pReason;
		this.mRepId = pRepId;
	}

	public String getImei() {
		return mImei;
	}

	public String getProgramId() {
		return mProgramId;
	}

	public String getReason() {
		return mReason;
	}

	public String getRepId() {
		return mRepId;
	}

	public String getState() {
		return mState;
	}

	public void setImei(String pImei) {
		this.mImei = pImei;
	}

	public void setProgramId(String pProgram) {
		this.mProgramId = pProgram;
	}

	public void setReason(String pReason) {
		this.mReason = pReason;
	}

	public void setRepId(String pRepId) {
		this.mRepId = pRepId;
	}

	public void setState(String pState) {
		this.mState = pState;
	}

	@Override
	public String toString() {
		return "Device [imei=" + mImei + ", programId=" + mProgramId + ", state=" + mState + ", reason=" + mReason
				+ ", repId=" + mRepId + "]";
	}

}