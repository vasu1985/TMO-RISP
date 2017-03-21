package com.tmobile.retailinventoryserialization.base.domain.shared;

import java.io.Serializable;

public class BaseResponse<O> implements Serializable {
	private static final long serialVersionUID = 1L;
	private FieldError fieldError;
	private O result;
	public FieldError getFieldError() {
		return fieldError;
	}
	public void setFieldError(FieldError fieldError) {
		this.fieldError = fieldError;
	}
	public O getResult() {
		return result;
	}
	public void setResult(O result) {
		this.result = result;
	}
	

}
