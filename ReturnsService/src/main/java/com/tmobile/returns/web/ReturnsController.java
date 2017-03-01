package com.tmobile.returns.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.returns.domain.Device;
import com.tmobile.returns.service.ReturnsService;

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
@CrossOrigin("*")
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

	/** The Constant GET_USER_AUTHENTICATION. */
	public static final String GET_CONFIRM_STATUS = "confirmStatus";

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

	@RequestMapping(value = "${returnService.labelDetails.url.mapping}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String getLabelDetails(@RequestBody(required = false) Device device) {
		log.info(GET_LABEL_DETAILS);
		String json = mReturnService.getLabelDetails();

		return json;
	}

	/**
	 * This service is called in Returns Service flow, to Label details.
	 *
	 * @return the Label Details items
	 */

	/*@RequestMapping(value = "${returnService.confirm.url.mapping}", method = RequestMethod.POST)
	public String getConfirmation(@RequestBody(required = false) Device device) {
		log.info(GET_LABEL_DETAILS);
		String json = mReturnService.getConfirmation();

		return json;
	}*/

	/**
	 * This service is called in Returns Service flow, to IMEI details.
	 *
	 * @return the IEMI Details items
	 */

	/*
	 * @RequestMapping(value = "${returnService.authenticateUser.url.mapping}",
	 * method = RequestMethod.POST, consumes = "application/json", produces =
	 * "application/json") public AuthDetails authenticateUser(@RequestBody
	 * UserDetails user) // public String authenticateUser() {
	 * System.out.println("JSON authenticate user:" + user.getName());
	 * log.info(GET_USER_AUTHENTICATION); String json = null;
	 * 
	 * List<UserDetails> users = mReturnService.getUsers(); for (UserDetails u :
	 * users) { u.getName().equalsIgnoreCase(user.getName()); if
	 * (u.getName().equalsIgnoreCase(user.getName()) &&
	 * u.getPassword().equals(user.getPassword())) { return
	 * mReturnService.authenticateUser(u.getName());
	 * 
	 * } }
	 * 
	 * return null; }
	 * 
	 * @RequestMapping(value = "/tmo/resources/services/users", method =
	 * RequestMethod.POST) public String addUser(@RequestBody UserDetails user)
	 * { // log.info(ADD_USER);
	 * 
	 * return mReturnService.addUser(user); }
	 * 
	 * @RequestMapping(value = "/tmo/resources/services/users", method =
	 * RequestMethod.GET) public List<UserDetails> getUsers() {
	 * System.out.println(
	 * "##########################################  GET STORES  #####################################################"
	 * ); return mReturnService.getUsers(); }
	 */
}
