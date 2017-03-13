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
public class Device implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** The imei. */
	@Id
	@JsonProperty("imei")
    private String mImei;

    /** The program. */
    @JsonProperty("program")
    private String mProgram;

    /** The current state. */
    @JsonProperty("currentState")
    private String mCurrentState;

    /** The reason. */
    @JsonProperty("reason")
    private String mReason;
	
	public Device(){
		
	}

	public String getmImei() {
		return mImei;
	}

	public void setmImei(String mImei) {
		this.mImei = mImei;
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

	public String getmReason() {
		return mReason;
	}

	public void setmReason(String mReason) {
		this.mReason = mReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Device(String mImei, String mProgram, String mCurrentState, String mReason) {
		super();
		this.mImei = mImei;
		this.mProgram = mProgram;
		this.mCurrentState = mCurrentState;
		this.mReason = mReason;
	}

	@Override
	public String toString() {
		return "Device [mImei=" + mImei + ", mProgram=" + mProgram + ", mCurrentState=" + mCurrentState + ", mReason="
				+ mReason + "]";
	}

     
}