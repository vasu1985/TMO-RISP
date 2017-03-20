package com.tmobile.retailinventorycommandservice.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS Device
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:28:41 PM Author: SS00443175
 */
@Region("devices")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The imei. */
	@Id
	@JsonProperty("imei")
	private String mImei;

	/** The program. */
	@JsonProperty("programId")
	private String mProgramId;

	/** The current state. */ 
	@JsonProperty("state")
	private String mState;

	/** The reason. */
	@JsonProperty("reason")
	private String mReason;

	/** The reason. */
	@JsonProperty("repId")
	private String mRepId;

	public Device() {

	}

	public String getmImei() {
		return mImei;
	}

	public void setmImei(String mImei) {
		this.mImei = mImei;
	}

	public String getmProgramId() {
		return mProgramId;
	}

	public void setmProgramId(String mProgram) {
		this.mProgramId = mProgram;
	}

	public String getmReason() {
		return mReason;
	}

	public void setmReason(String mReason) {
		this.mReason = mReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getmRepId() {
		return mRepId;
	}

	public void setmRepId(String mRepId) {
		this.mRepId = mRepId;
	}

	public Device(String mImei, String mProgramId, String mState, String mReason, String mRepId) {
		super();
		this.mImei = mImei;
		this.mProgramId = mProgramId;
		this.mState = mState;
		this.mReason = mReason;
		this.mRepId = mRepId;
	}

	@Override
	public String toString() {
		return "Device [mImei=" + mImei + ", mProgramId=" + mProgramId + ", mState=" + mState + ", mReason=" + mReason
				+ ", mRepId=" + mRepId + "]";
	}

	public String getmState() {
		return mState;
	}

	public void setmState(String mState) {
		this.mState = mState;
	}

}