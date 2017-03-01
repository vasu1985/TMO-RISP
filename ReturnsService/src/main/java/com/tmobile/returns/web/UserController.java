package com.tmobile.returns.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.returns.domain.AuthDetails;
import com.tmobile.returns.domain.UserDetails;
import com.tmobile.returns.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "${returnService.authenticateUser.url.mapping}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AuthDetails authenticateUser(@RequestBody UserDetails user)
	{
		System.out.println("JSON authenticate user:" + user.getRepId());
		return userService.authenticateUser(user);

	}

	@RequestMapping(value = "/tmo/resources/services/users", method = RequestMethod.POST)
	public String addUser(@RequestBody UserDetails user) {

		return userService.addUser(user);
	}

	@RequestMapping(value = "/tmo/resources/services/users", method = RequestMethod.GET)
	public List<UserDetails> getUsers() {
		return userService.getUsers();
	}
}
