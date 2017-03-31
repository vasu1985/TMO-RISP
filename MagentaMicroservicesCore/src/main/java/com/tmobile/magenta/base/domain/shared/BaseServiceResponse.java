package com.tmobile.magenta.base.domain.shared;

import java.util.List;

public class BaseServiceResponse<O> implements BaseResponse {
	private static final long serialVersionUID = 1L;
	private O result;
	private List<FieldError> fieldErrors;

	public O getResult() {
		return result;
	}

	public void setResult(O result) {
		this.result = result;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
