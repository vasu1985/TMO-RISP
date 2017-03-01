package com.tmobile.returns.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.returns.domain.AuthDetails;
import com.tmobile.returns.domain.UserDetails;
import com.tmobile.returns.repository.UserRepository;
import com.tmobile.returns.utils.Constants;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	public static final String GET_USER_AUTHENTICATION = "authenticateUser";

	public AuthDetails authenticateUser(UserDetails loggedInUser) {
		log.info(GET_USER_AUTHENTICATION + Constants.LOG_INFO_VALUE);
		System.out.println("status is:" + loggedInUser);
		String role = null;
		for (UserDetails user : getUsers()) {
			if (null != user) {
				if (user.getRepId().equalsIgnoreCase(loggedInUser.getRepId())
						&& user.getPassword().equals(loggedInUser.getPassword())) {
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

	public String addUser(UserDetails user) {
		userRepository.save(user);
		return "User " + user.getRepId() + " added successfully";

	}

	public List<UserDetails> getUsers() {
		List<UserDetails> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
}
