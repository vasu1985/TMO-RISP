package com.tmobile.retailinventoryservice.domain;

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
@Region("queryDevice")
public class Device implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** The imei. */
	@Id
	@JsonProperty("mImei")
    private String mImei;

    /** The sku. */
	@JsonProperty("mSku")
    private String mSku;

    /** The rep id. */
	@JsonProperty("mRepId")
    private String mRepId;

    /** The description. */
    @JsonProperty("mDescription")
    private String mDescription;

    /** The program. */
    @JsonProperty("mProgram")
    private String mProgram;

    /** The current state. */
    @JsonProperty("mCurrentState")
    private String mCurrentState;

    /** The change state. */
    @JsonProperty("mChangeState")
    private String mChangeState;

    /** The reason. */
    @JsonProperty("mReason")
    private String mReason;

    
	public Device(String mImei, String mSku, String mRepId, String mDescription, String mProgram, String mCurrentState,
			String mChangeState, String mReason) {
		
		this.mImei = mImei;
		this.mSku = mSku;
		this.mRepId = mRepId;
		this.mDescription = mDescription;
		this.mProgram = mProgram;
		this.mCurrentState = mCurrentState;
		this.mChangeState = mChangeState;
		this.mReason = mReason;
	}
	
	public Device(){
		
	}

	public String getmImei() {
		return mImei;
	}

	public void setmImei(String mImei) {
		this.mImei = mImei;
	}

	public String getmSku() {
		return mSku;
	}

	public void setmSku(String mSku) {
		this.mSku = mSku;
	}

	public String getmRepId() {
		return mRepId;
	}

	public void setmRepId(String mRepId) {
		this.mRepId = mRepId;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getmProgram() {
		return mProgram;
	}

	public void setmProgram(String mProgram) {
		this.mProgram = mProgram;
	}

	public String getmCurrentState() {
		return mCurrentState;
	}

	public void setmCurrentState(String mCurrentState) {
		this.mCurrentState = mCurrentState;
	}

	public String getmChangeState() {
		return mChangeState;
	}

	public void setmChangeState(String mChangeState) {
		this.mChangeState = mChangeState;
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

	@Override
	public String toString() {
		return "Device [mImei=" + mImei + ", mSku=" + mSku + ", mRepId=" + mRepId + ", mDescription=" + mDescription
				+ ", mProgram=" + mProgram + ", mCurrentState=" + mCurrentState + ", mChangeState=" + mChangeState
				+ ", mReason=" + mReason + "]";
	}

     
}