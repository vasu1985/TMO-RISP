
package com.tmobile.retailinventoryserializationservice.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.retailinventoryserializationservice.user.domain.AuthDetails;
import com.tmobile.retailinventoryserializationservice.user.domain.UserInfo;
import com.tmobile.retailinventoryserializationservice.user.repository.UserRepository;
import com.tmobile.retailinventoryservice.utils.Constants;

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
public class UserService {

    /** The user repository. */
    @Autowired
    private UserRepository     userRepository;

    /** The log. */
    private static Logger      log                     = LoggerFactory.getLogger(UserService.class);

    /** The Constant GET_USER_AUTHENTICATION. */
    public static final String GET_USER_AUTHENTICATION = "authenticateUser";

    /**
     * Authenticate user.
     *
     * @param loggedInUser
     *            the logged in user
     * @return the auth details
     */
    public AuthDetails authenticateUser( UserInfo loggedInUser) {
        log.info(GET_USER_AUTHENTICATION + Constants.LOG_INFO_VALUE);
        System.out.println("status is:" + loggedInUser);
        String role = null;
        for ( UserInfo user : getUsers()) {
            if (null != user) {
                if (user.getRepId().equalsIgnoreCase(loggedInUser.getRepId()) && user.getPassword().equals(loggedInUser.getPassword())) {
                    role = user.getRole();
                }
            }
        }

        if (null == role) {
            return new AuthDetails("fail", "login fail", "fail");
        } else if ("Store Manager".equals(role))
            return new AuthDetails("success", "login successful", "success");
        else
            return new AuthDetails("success", "login successful", "fail");

    }

    /**
     * Adds the user.
     *
     * @param user
     *            the user
     * @return the string
     */
    public String addUser( UserInfo user) {
        userRepository.save(user);
        return "User " + user.getRepId() + " added successfully";

    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<UserInfo> getUsers() {
        List<UserInfo> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
