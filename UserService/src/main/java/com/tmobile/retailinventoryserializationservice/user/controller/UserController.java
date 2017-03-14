
package com.tmobile.retailinventoryserializationservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.retailinventoryserializationservice.user.domain.AuthDetails;
import com.tmobile.retailinventoryserializationservice.user.domain.UserInfo;
import com.tmobile.retailinventoryserializationservice.user.service.UserService;

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
@RequestMapping( "/user")
public class UserController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Authenticate user.
     *
     * @param user
     *            the user
     * @return the auth details
     */
    @RequestMapping( value = "${retailInventoryService.authenticateUser.url.mapping}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public AuthDetails authenticateUser( @RequestBody UserInfo user) {
        System.out.println("JSON authenticate user:" + user.getRepId());
        return userService.authenticateUser(user);

    }

    /**
     * Adds the user.
     *
     * @param user
     *            the user
     * @return the string
     */
    @RequestMapping( value = "/tmo/resources/services/users", method = RequestMethod.POST)
    public String addUser( @RequestBody UserInfo user) {

        return userService.addUser(user);
    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    @RequestMapping( value = "/tmo/resources/services/users", method = RequestMethod.GET)
    public List<UserInfo> getUsers() {
        return userService.getUsers();
    }
}
