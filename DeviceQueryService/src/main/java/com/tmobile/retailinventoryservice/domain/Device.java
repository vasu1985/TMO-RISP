
package com.tmobile.retailinventoryservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class Device {

    /** The imei. */
    @Id
    private String mImei;

    /** The sku. */
    private String mSku;

    /** The rep id. */
    private String mRepId;

    /** The description. */
    private String mDescription;

    /** The program. */
    private String mProgram;

    /** The current state. */
    private String mCurrentState;

    /** The change state. */
    private String mChangeState;

    /** The reason. */
    private String mReason;

    /**
     * Gets the current state.
     *
     * @return the current state
     */
    public String getCurrentState() {
        return mCurrentState;
    }

    /**
     * Sets the current state.
     *
     * @param currentState
     *            the current state
     */
    public void setCurrentState( String currentState) {
        this.mCurrentState = currentState;
    }

    /**
     * Gets the change state.
     *
     * @return the change state
     */
    public String getChangeState() {
        return mChangeState;
    }

    /**
     * Sets the change state.
     *
     * @param changeState
     *            the change state
     */
    public void setChangeState( String changeState) {
        this.mChangeState = changeState;
    }

    /**
     * Gets the reason.
     *
     * @return the reason
     */
    public String getReason() {
        return mReason;
    }

    /**
     * Sets the reason.
     *
     * @param reason
     *            the reason
     */
    public void setReason( String reason) {
        this.mReason = reason;
    }

    /**
     * Gets the sku.
     *
     * @return the sku
     */
    public String getSku() {
        return mSku;
    }

    /**
     * Sets the sku.
     *
     * @param sku
     *            the sku
     */
    public void setSku( String sku) {
        this.mSku = sku;
    }

    /**
     * Gets the rep id.
     *
     * @return the rep id
     */
    public String getRepId() {
        return mRepId;
    }

    /**
     * Sets the rep id.
     *
     * @param repId
     *            the rep id
     */
    public void setRepId( String repId) {
        this.mRepId = repId;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the description
     */
    public void setDescription( String description) {
        this.mDescription = description;
    }

    /**
     * Gets the program.
     *
     * @return the program
     */
    public String getProgram() {
        return mProgram;
    }

    /**
     * Sets the program.
     *
     * @param program
     *            the program
     */
    public void setProgram( String program) {
        this.mProgram = program;
    }

    /**
     * Gets the imei.
     *
     * @return the imei
     */
    public String getImei() {
        return mImei;
    }

    /**
     * Sets the imei.
     *
     * @param imei
     *            the imei
     */
    public void setImei( String imei) {
        this.mImei = imei;
    }
}
