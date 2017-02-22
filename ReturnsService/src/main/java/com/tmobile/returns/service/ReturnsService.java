package com.tmobile.returns.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tmobile.returns.utils.Constants;
import com.tmobile.returns.utils.UserDetails;

/**
 * The Class ReturnService.
 */
@Service
public class ReturnsService {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(ReturnsService.class);

	/** The Constant GET_SCAN_IMEI_DETAILS. */
	public static final String GET_SCAN_IMEI_DETAILS = "getScanIMEIDetails";

	/** The Constant GET_LABEL_DETAILS. */
	public static final String GET_LABEL_DETAILS = "getLabelDetails";

	/** The Constant GET_USER_AUTHENTICATION. */
	public static final String GET_USER_AUTHENTICATION = "authenticateUser";

	@Value("${returnService.scanIMEI.sampleJson}")
	private String sampleJson_imei;

	@Value("${returnService.labelDetails.sampleJson}")
	private String sampleJson_label;

	@Value("${returnService.authenticateUser.sampleJsonAuthSuccess}")
	private String sampleJson_authSuccess;

	@Value("${returnService.authenticateUser.sampleJsonAuthFailure}")
	private String sampleJson_authFailure;

	/**
	 * Gets the scan IMEI details.
	 *
	 * @return the scan IMEI details.
	 */
	public String getScanIMEIDetails() {
		log.info(GET_LABEL_DETAILS + Constants.LOG_INFO_VALUE);
		return sampleJson_imei;
	}

	/**
	 * Gets the label details.
	 *
	 * @return the label details.
	 */
	public String getLabelDetails() {
		log.info(GET_SCAN_IMEI_DETAILS + Constants.LOG_INFO_VALUE);
		return sampleJson_label;
	}

	/**
	 * Gets the auth details.
	 * 
	 * @param user
	 *
	 * @return the auth response.
	 */
	public String authenticateUser(UserDetails user) {
		log.info(GET_USER_AUTHENTICATION + Constants.LOG_INFO_VALUE);
		if (user.getName().equalsIgnoreCase("techm"))
			return sampleJson_authSuccess;
		else
			return sampleJson_authFailure;
	}
}
