package com.tmobile.retailinventoryserialization.base.domain.shared;

public class BaseRestRequest<O> extends BaseRequest {
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
