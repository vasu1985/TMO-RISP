package com.tmobile.retailinventoryserialization.base.domain.shared;

import java.io.Serializable;

public class BaseRequest<O> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private O request;
	private String sourceSystem;

	public O getRequest() {
		return request;
	}

	public void setRequest(O request) {
		this.request = request;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

}
