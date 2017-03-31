
package com.tmobile.retailinventoryserialization.command.device.domain.shared;

import org.springframework.data.gemfire.mapping.Region;

import com.tmobile.magenta.base.domain.shared.BaseRequest;

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
@Region("devices")
public class UserInfo implements BaseRequest {

	/**
	 * comment for this field
	 */

	private static final long serialVersionUID = 1L;

	/** The rep id. */

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
	 * public User(String repId, String role, String description, String
	 * autherization, String authentication) { super(); this.repId = repId;
	 * this.role = role; this.description = description; }
	 */

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return mPassword;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return mRole;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the description
	 */
	public void setDescription(String description) {
		this.mDescription = description;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password
	 */
	public void setPassword(String password) {
		this.mPassword = password;
	}

	/**
	 * Sets the rep id.
	 *
	 * @param repId
	 *            the rep id
	 */
	public void setRepId(String repId) {
		this.mRepId = repId;
	}

	/**
	 * Sets the role.
	 *
	 * @param role
	 *            the role
	 */
	public void setRole(String role) {
		this.mRole = role;
	}
}
