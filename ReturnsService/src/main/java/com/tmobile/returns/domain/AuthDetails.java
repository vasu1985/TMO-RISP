package com.tmobile.returns.domain;

public class AuthDetails {

	public AuthDetails() {
	}

	public AuthDetails(String authentication, String description, String autherization) {
		super();
		this.authentication = authentication;
		this.description = description;
		this.autherization = autherization;
	}

	private String authentication;

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAutherization() {
		return autherization;
	}

	public void setAutherization(String autherization) {
		this.autherization = autherization;
	}

	private String description;
	private String autherization;

}
