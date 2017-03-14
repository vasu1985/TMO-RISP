
package com.tmobile.retailinventoryserializationservice.user.domain;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS AuthDetails
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:27:38 PM Author: SS00443175
 */
public class AuthDetails {

    /** The description. */
    private String mDescription;

    /** The autherization. */
    private String mAutherization;

    /** The authentication. */
    private String mAuthentication;

    /**
     * The Constructor.
     */
    public AuthDetails() {
        /* Default Constructor */
    }

    /**
     * The Constructor.
     *
     * @param authentication
     *            the authentication
     * @param description
     *            the description
     * @param autherization
     *            the autherization
     */
    public AuthDetails( String authentication, String description, String autherization) {
        super();
        this.mAuthentication = authentication;
        this.mDescription = description;
        this.mAutherization = autherization;
    }

    /**
     * Gets the authentication.
     *
     * @return the authentication
     */
    public String getAuthentication() {
        return mAuthentication;
    }

    /**
     * Sets the authentication.
     *
     * @param authentication
     *            the authentication
     */
    public void setAuthentication( String authentication) {
        this.mAuthentication = authentication;
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
     * Gets the autherization.
     *
     * @return the autherization
     */
    public String getAutherization() {
        return mAutherization;
    }

    /**
     * Sets the autherization.
     *
     * @param autherization
     *            the autherization
     */
    public void setAutherization( String autherization) {
        this.mAutherization = autherization;
    }

}
