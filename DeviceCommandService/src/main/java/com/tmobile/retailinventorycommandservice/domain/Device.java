
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
@Region( "devices")
public class Device implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The imei. */
    @Id
    @JsonProperty( "imei")
    private String            mImei;

    /** The program. */
    @JsonProperty( "programId")
    private String            mProgramId;

    /** The current state. */
    @JsonProperty( "state")
    private String            mState;

    /** The reason. */
    @JsonProperty( "reason")
    private String            mReason;

    /** The reason. */
    @JsonProperty( "repId")
    private String            mRepId;

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
     * @param mProgramId
     *            the m program id
     * @param mState
     *            the m state
     * @param mReason
     *            the m reason
     * @param mRepId
     *            the m rep id
     */
    public Device( String mImei, String mProgramId, String mState, String mReason, String mRepId) {
        super();
        this.mImei = mImei;
        this.mProgramId = mProgramId;
        this.mState = mState;
        this.mReason = mReason;
        this.mRepId = mRepId;
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
     * @param mProgram
     *            the m program id
     */
    public void setmProgramId( String mProgram) {
        this.mProgramId = mProgram;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Device [mImei=" + mImei + ", mProgramId=" + mProgramId + ", mState=" + mState + ", mReason=" + mReason + ", mRepId=" + mRepId + "]";
    }

}