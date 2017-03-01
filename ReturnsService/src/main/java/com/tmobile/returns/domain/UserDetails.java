package com.tmobile.returns.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private String repId;
	private String password;
	private String role;
	private String description;

	public UserDetails() {

	}

	public UserDetails(String repId, String role, String description, String autherization, String authentication) {
		super();
		this.repId = repId;
		this.role = role;
		this.description = description;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}
}
