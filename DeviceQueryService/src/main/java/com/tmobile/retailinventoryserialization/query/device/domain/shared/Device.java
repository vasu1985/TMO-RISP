package com.tmobile.retailinventoryserialization.query.device.domain.shared;

import java.io.Serializable;

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
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:28:41 PM Author: SS00443175
 */
@Region("queryDevice")
public class Device implements BaseRequest {

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

	public String getImei() {
		return mImei;
	}

	public void setImei(String mImei) {
		this.mImei = mImei;
	}

	public String getSku() {
		return mSku;
	}

	public void setSku(String mSku) {
		this.mSku = mSku;
	}

	public String getRepId() {
		return mRepId;
	}

	public void setRepId(String mRepId) {
		this.mRepId = mRepId;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getReason() {
		return mReason;
	}

	public void setReason(String mReason) {
		this.mReason = mReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStockTransferOrderId() {
		return mStockTransferOrderId;
	}

	public void setStockTransferOrderId(String mStockTransferOrderId) {
		this.mStockTransferOrderId = mStockTransferOrderId;
	}

	public String getAccountId() {
		return mAccountId;
	}

	public void setAccountId(String mAccountId) {
		this.mAccountId = mAccountId;
	}

	public String getProgramId() {
		return mProgramId;
	}

	public void setProgramId(String mProgramId) {
		this.mProgramId = mProgramId;
	}

	public String getOwningStoreId() {
		return mOwningStoreId;
	}

	public void setOwningStoreId(String mOwningStoreId) {
		this.mOwningStoreId = mOwningStoreId;
	}

	public String getState() {
		return mState;
	}

	public void setState(String mState) {
		this.mState = mState;
	}

	public String getMake() {
		return mMake;
	}

	public void setMake(String mMake) {
		this.mMake = mMake;
	}

	public String getModel() {
		return mModel;
	}

	public void setModel(String mModel) {
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