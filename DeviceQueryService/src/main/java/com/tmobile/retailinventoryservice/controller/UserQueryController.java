
package com.tmobile.retailinventoryservice.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.retailinventoryservice.domain.AuthDetails;
import com.tmobile.retailinventoryservice.domain.UserInfo;
import com.tmobile.retailinventoryservice.service.UserQueryService;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS UserController
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:30:06 PM Author: SS00443175
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserQueryController {

	/** The log. */
    private static Logger      log                   = LoggerFactory.getLogger(UserQueryController.class);

	/** The user service. */
	@Autowired
	private UserQueryService userQueryService;

	/**
	 * Authenticate user.
	 *
	 * @param user
	 *            the user
	 * @return the auth details
	 */
	@RequestMapping(value = "${retailInventoryService.authenticateUser.url.mapping}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AuthDetails authenticateUser(@RequestBody UserInfo user) {
		log.info("JSON authenticate user:" + user.getRepId());
		return userQueryService.authenticateUser(user);
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@RequestMapping(value = "/tmo/resources/services/users", method = RequestMethod.GET)
	public List<UserInfo> getUsers() {
//		return userQueryService.getUsers();
		return Arrays.asList(new UserInfo("test1", "pwd", "Store Manager", "This is Manager"));
	}
}
