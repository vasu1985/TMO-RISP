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
@Region("transactions")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** The imei. */
	@Id
	@JsonProperty("imei")
    private String mImei;

    /** The current state. */
    @JsonProperty("currentState")
    private String mCurrentState;

    /** The reason. */
    @JsonProperty("reason")
    private String mReason;
    
    /** The repId. */
    @JsonProperty("repId")
    private String mRepId;
	
    /** The status. */
    @JsonProperty("status")
    private String mStatus;
    
    /** The queueName. */
    @JsonProperty("queueName")
    private String mQueueName;
    
	
    
	public Transaction(){
		
	}

	public String getmImei() {
		return mImei;
	}

	public void setmImei(String mImei) {
		this.mImei = mImei;
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

	public String getmRepId() {
		return mRepId;
	}

	public void setmRepId(String mRepId) {
		this.mRepId = mRepId;
	}

	@Override
	public String toString() {
		return "Transaction [mImei=" + mImei + ", mCurrentState=" + mCurrentState + ", mReason=" + mReason + ", mRepId="
				+ mRepId + ", mStatus=" + mStatus + ", queueName=" + mQueueName + "]";
	}

	public Transaction(String mImei, String mProgram, String mCurrentState, String mReason, String mRepId, String mStatus, String mQueueName) {
		super();
		this.mImei = mImei;
		this.mCurrentState = mCurrentState;
		this.mReason = mReason;
		this.mRepId = mRepId;
		this.mStatus = mStatus;
		this.mQueueName = mQueueName;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	public String getQueueName() {
		return mQueueName;
	}

	public void setQueueName(String queueName) {
		this.mQueueName = queueName;
	}


     
}