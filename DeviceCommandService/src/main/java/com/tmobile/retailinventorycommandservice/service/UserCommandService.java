
package com.tmobile.retailinventorycommandservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.retailinventorycommandservice.domain.UserInfo;
import com.tmobile.retailinventorycommandservice.repository.UserCommandRepository;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS UserService
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:29:25 PM Author: SS00443175
 */
@Service
public class UserCommandService {

	/** The log. */
    private static Logger      log                   = LoggerFactory.getLogger(UserCommandService.class);

	/** The user repository. */
	@Autowired
	private UserCommandRepository userCommandRepository;

	/** The Constant GET_USER_AUTHENTICATION. */
	public static final String GET_USER_AUTHENTICATION = "authenticateUser";

	/**
	 * Adds the user.
	 *
	 * @param user
	 *            the user
	 * @return the string
	 */
	public String addUser(UserInfo user) {
		userCommandRepository.save(user);
		log.info("AddUser :"+user.getRepId());
		return "User " + user.getRepId() + " added successfully";

	}
}
