package com.tmobile.magenta.base.domain.shared;

public class BaseServiceRequest<O> implements BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private O request;

	public O getRequest() {
		return request;
	}

	public void setRequest(O request) {
		this.request = request;
	}

}
