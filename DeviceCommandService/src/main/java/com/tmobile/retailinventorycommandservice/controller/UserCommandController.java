package com.tmobile.retailinventorycommandservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.retailinventorycommandservice.domain.UserInfo;
import com.tmobile.retailinventorycommandservice.service.UserCommandService;

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
public class UserCommandController {

	/** The user service. */
	@Autowired
	private UserCommandService userCommandService;

	/**
	 * Adds the user.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	@RequestMapping(value = "/tmo/resources/services/users", method = RequestMethod.POST)
	public String addUser(@RequestBody UserInfo user) {

		return userCommandService.addUser(user);
	}

}
