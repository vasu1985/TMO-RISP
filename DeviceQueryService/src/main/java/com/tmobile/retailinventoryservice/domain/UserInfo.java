
package com.tmobile.retailinventoryservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS UserInfo
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:28:49 PM Author: SS00443175
 */
@Entity
public class UserInfo {

    /** The rep id. */
    @Id
    private String mRepId;

    /** The password. */
    private String mPassword;

    /** The role. */
    private String mRole;

    /** The description. */
    private String mDescription;

    /**
     * The Constructor.
     */
    public UserInfo() {

    }
    /*
     * public User(String repId, String role, String description, String autherization, String authentication) { super(); this.repId = repId; this.role = role;
     * this.description = description; }
     */

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return mPassword;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the password
     */
    public void setPassword( String password) {
        this.mPassword = password;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return mRole;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the role
     */
    public void setRole( String role) {
        this.mRole = role;
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
}
