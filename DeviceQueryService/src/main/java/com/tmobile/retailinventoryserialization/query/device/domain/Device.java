package com.tmobile.retailinventoryserialization.query.device.domain;

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
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The imei. */
	@Id
	@JsonProperty("imei")
	private String mImei;
	/** The sku. */
	@JsonProperty("sku")
	private String mSku;

	@JsonProperty("stockTransferOrderId")
	private String mStockTransferOrderId;

	@JsonProperty("accountId")
	private String mAccountId;

	@JsonProperty("programId")
	private String mProgramId;

	@JsonProperty("owningStoreId")
	private String mOwningStoreId;

	/** The rep id. */
	@JsonProperty("repId")
	private String mRepId;

	/** The description. */
	@JsonProperty("description")
	private String mDescription;

	/** The current state. */
	@JsonProperty("state")
	private String mState;

	/** The reason. */
	@JsonProperty("reason")
	private String mReason;

	@JsonProperty("make")
	private String mMake;

	@JsonProperty("model")
	private String mModel;

	public Device() {

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

	public String getmReason() {
		return mReason;
	}

	public void setmReason(String mReason) {
		this.mReason = mReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getmStockTransferOrderId() {
		return mStockTransferOrderId;
	}

	public void setmStockTransferOrderId(String mStockTransferOrderId) {
		this.mStockTransferOrderId = mStockTransferOrderId;
	}

	public String getmAccountId() {
		return mAccountId;
	}

	public void setmAccountId(String mAccountId) {
		this.mAccountId = mAccountId;
	}

	public String getmProgramId() {
		return mProgramId;
	}

	public void setmProgramId(String mProgramId) {
		this.mProgramId = mProgramId;
	}

	public String getmOwningStoreId() {
		return mOwningStoreId;
	}

	public void setmOwningStoreId(String mOwningStoreId) {
		this.mOwningStoreId = mOwningStoreId;
	}

	public String getmState() {
		return mState;
	}

	public void setmState(String mState) {
		this.mState = mState;
	}

	public String getmMake() {
		return mMake;
	}

	public void setmMake(String mMake) {
		this.mMake = mMake;
	}

	public String getmModel() {
		return mModel;
	}

	public void setmModel(String mModel) {
		this.mModel = mModel;
	}

	@Override
	public String toString() {
		return "Device [mImei=" + mImei + ", mSku=" + mSku + ", mStockTransferOrderId=" + mStockTransferOrderId
				+ ", mAccountId=" + mAccountId + ", mProgramId=" + mProgramId + ", mOwningStoreId=" + mOwningStoreId
				+ ", mRepId=" + mRepId + ", mDescription=" + mDescription + ", mState=" + mState + ", mReason="
				+ mReason + ", mMake=" + mMake + ", mModel=" + mModel + "]";
	}

	public Device(String mImei, String mSku, String mStockTransferOrderId, String mAccountId, String mProgramId,
			String mOwningStoreId, String mRepId, String mDescription, String mState, String mReason, String mMake,
			String mModel) {
		super();
		this.mImei = mImei;
		this.mSku = mSku;
		this.mStockTransferOrderId = mStockTransferOrderId;
		this.mAccountId = mAccountId;
		this.mProgramId = mProgramId;
		this.mOwningStoreId = mOwningStoreId;
		this.mRepId = mRepId;
		this.mDescription = mDescription;
		this.mState = mState;
		this.mReason = mReason;
		this.mMake = mMake;
		this.mModel = mModel;
	}

}