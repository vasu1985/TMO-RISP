package com.tmobile.retailinventoryserialization.base.domain.shared;

import java.util.List;

public class BaseServiceResponse<O> implements BaseRequest {
	private static final long serialVersionUID = 1L;
	private List<FieldError> fieldError;
	private O result;

	public O getResult() {
		return result;
	}

	public void setResult(O result) {
		this.result = result;
	}

	public List<FieldError> getFieldError() {
		return fieldError;
	}

	public void setFieldError(List<FieldError> fieldError) {
		this.fieldError = fieldError;
	}

}
