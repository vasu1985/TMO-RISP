
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
@Region( "queryDevice")
public class Device implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The imei. */
    @Id
    @JsonProperty( "imei")
    private String            mImei;
    /** The sku. */
    @JsonProperty( "sku")
    private String            mSku;

    /** The m stock transfer order id. */
    @JsonProperty( "stockTransferOrderId")
    private String            mStockTransferOrderId;

    /** The m account id. */
    @JsonProperty( "accountId")
    private String            mAccountId;

    /** The m program id. */
    @JsonProperty( "programId")
    private String            mProgramId;

    /** The m owning store id. */
    @JsonProperty( "owningStoreId")
    private String            mOwningStoreId;

    /** The rep id. */
    @JsonProperty( "repId")
    private String            mRepId;

    /** The description. */
    @JsonProperty( "description")
    private String            mDescription;

    /** The current state. */
    @JsonProperty( "state")
    private String            mState;

    /** The reason. */
    @JsonProperty( "reason")
    private String            mReason;

    /** The m make. */
    @JsonProperty( "make")
    private String            mMake;

    /** The m model. */
    @JsonProperty( "model")
    private String            mModel;

    /**
     * The Constructor.
     */
    public Device() {

    }

    /**
     * The Constructor.
     *
     * @param mImei
     *            the m imei
     * @param mSku
     *            the m sku
     * @param mStockTransferOrderId
     *            the m stock transfer order id
     * @param mAccountId
     *            the m account id
     * @param mProgramId
     *            the m program id
     * @param mOwningStoreId
     *            the m owning store id
     * @param mRepId
     *            the m rep id
     * @param mDescription
     *            the m description
     * @param mState
     *            the m state
     * @param mReason
     *            the m reason
     * @param mMake
     *            the m make
     * @param mModel
     *            the m model
     */
    public Device( String mImei, String mSku, String mStockTransferOrderId, String mAccountId, String mProgramId, String mOwningStoreId, String mRepId,
            String mDescription, String mState, String mReason, String mMake, String mModel) {
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

    /**
     * Getm imei.
     *
     * @return the m imei
     */
    public String getmImei() {
        return mImei;
    }

    /**
     * Setm imei.
     *
     * @param mImei
     *            the m imei
     */
    public void setmImei( String mImei) {
        this.mImei = mImei;
    }

    /**
     * Getm sku.
     *
     * @return the m sku
     */
    public String getmSku() {
        return mSku;
    }

    /**
     * Setm sku.
     *
     * @param mSku
     *            the m sku
     */
    public void setmSku( String mSku) {
        this.mSku = mSku;
    }

    /**
     * Getm rep id.
     *
     * @return the m rep id
     */
    public String getmRepId() {
        return mRepId;
    }

    /**
     * Setm rep id.
     *
     * @param mRepId
     *            the m rep id
     */
    public void setmRepId( String mRepId) {
        this.mRepId = mRepId;
    }

    /**
     * Getm description.
     *
     * @return the m description
     */
    public String getmDescription() {
        return mDescription;
    }

    /**
     * Setm description.
     *
     * @param mDescription
     *            the m description
     */
    public void setmDescription( String mDescription) {
        this.mDescription = mDescription;
    }

    /**
     * Getm reason.
     *
     * @return the m reason
     */
    public String getmReason() {
        return mReason;
    }

    /**
     * Setm reason.
     *
     * @param mReason
     *            the m reason
     */
    public void setmReason( String mReason) {
        this.mReason = mReason;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Getm stock transfer order id.
     *
     * @return the m stock transfer order id
     */
    public String getmStockTransferOrderId() {
        return mStockTransferOrderId;
    }

    /**
     * Setm stock transfer order id.
     *
     * @param mStockTransferOrderId
     *            the m stock transfer order id
     */
    public void setmStockTransferOrderId( String mStockTransferOrderId) {
        this.mStockTransferOrderId = mStockTransferOrderId;
    }

    /**
     * Getm account id.
     *
     * @return the m account id
     */
    public String getmAccountId() {
        return mAccountId;
    }

    /**
     * Setm account id.
     *
     * @param mAccountId
     *            the m account id
     */
    public void setmAccountId( String mAccountId) {
        this.mAccountId = mAccountId;
    }

    /**
     * Getm program id.
     *
     * @return the m program id
     */
    public String getmProgramId() {
        return mProgramId;
    }

    /**
     * Setm program id.
     *
     * @param mProgramId
     *            the m program id
     */
    public void setmProgramId( String mProgramId) {
        this.mProgramId = mProgramId;
    }

    /**
     * Getm owning store id.
     *
     * @return the m owning store id
     */
    public String getmOwningStoreId() {
        return mOwningStoreId;
    }

    /**
     * Setm owning store id.
     *
     * @param mOwningStoreId
     *            the m owning store id
     */
    public void setmOwningStoreId( String mOwningStoreId) {
        this.mOwningStoreId = mOwningStoreId;
    }

    /**
     * Getm state.
     *
     * @return the m state
     */
    public String getmState() {
        return mState;
    }

    /**
     * Setm state.
     *
     * @param mState
     *            the m state
     */
    public void setmState( String mState) {
        this.mState = mState;
    }

    /**
     * Getm make.
     *
     * @return the m make
     */
    public String getmMake() {
        return mMake;
    }

    /**
     * Setm make.
     *
     * @param mMake
     *            the m make
     */
    public void setmMake( String mMake) {
        this.mMake = mMake;
    }

    /**
     * Getm model.
     *
     * @return the m model
     */
    public String getmModel() {
        return mModel;
    }

    /**
     * Setm model.
     *
     * @param mModel
     *            the m model
     */
    public void setmModel( String mModel) {
        this.mModel = mModel;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Device [mImei=" + mImei + ", mSku=" + mSku + ", mStockTransferOrderId=" + mStockTransferOrderId + ", mAccountId=" + mAccountId + ", mProgramId="
                + mProgramId + ", mOwningStoreId=" + mOwningStoreId + ", mRepId=" + mRepId + ", mDescription=" + mDescription + ", mState=" + mState
                + ", mReason=" + mReason + ", mMake=" + mMake + ", mModel=" + mModel + "]";
    }

}