package com.tmobile.returns.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.returns.service.ReturnsService;
import com.tmobile.returns.utils.Device;
import com.tmobile.returns.utils.UserDetails;

/**
 * <p>
 * ReturnController Class is the controller class for the Returns Microservice
 * </p>
 * .
 *
 * @author AB00334861
 * @project RISP
 * 
 */
@RestController
public class ReturnsController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(ReturnsController.class);
	/** The Account service. */
	@Autowired
	private ReturnsService mReturnService;

	/** The Constant GET_SCAN_IMEI_DETAILS. */
	public static final String GET_SCAN_IMEI_DETAILS = "getScanIMEIDetails";

	/** The Constant GET_LABEL_DETAILS. */
	public static final String GET_LABEL_DETAILS = "getLabelDetails";

	/** The Constant GET_USER_AUTHENTICATION. */
	public static final String GET_USER_AUTHENTICATION = "authenticateUser";

	/**
	 * This service is called in Returns Service flow, to IMEI details.
	 *
	 * @return the IEMI Details items
	 */

	@RequestMapping(value = "${returnService.imeiDetails.url.mapping}", method = RequestMethod.GET)
	public String getScanIMEIDetails() {
		log.info(GET_SCAN_IMEI_DETAILS);
		String json = mReturnService.getScanIMEIDetails();

		return json;
	}

	/**
	 * This service is called in Returns Service flow, to Label details.
	 *
	 * @return the Label Details items
	 */

	@RequestMapping(value = "${returnService.labelDetails.url.mapping}", method = RequestMethod.POST)
	public String getLabelDetails(@RequestBody(required = false) Device device) {
		log.info(GET_LABEL_DETAILS);
		String json = mReturnService.getLabelDetails();

		return json;
	}

	/**
	 * This service is called in Returns Service flow, to IMEI details.
	 *
	 * @return the IEMI Details items
	 */

	@RequestMapping(value = "${returnService.authenticateUser.url.mapping}", method = RequestMethod.POST)
	public String authenticateUser(@RequestBody(required = false) UserDetails user) {
		log.info(GET_USER_AUTHENTICATION);
		
		return mReturnService.authenticateUser(user);
	}
}
