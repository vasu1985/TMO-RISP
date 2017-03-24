
package com.tmobile.retailinventoryserialization.command.device.exception;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Null;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.base.domain.shared.FieldError;

/**
 * Exception handlers
 *
 * @author Arun Kishor
 */
@ControllerAdvice
@RequestMapping(produces = "application/json")
public class DefaultExceptionHandler {

	private final Log log = LogFactory.getLog(getClass());

	/**
	 * Handles constraint violation exceptions
	 *
	 * @param ex
	 *            the exception
	 * @return the error response
	 */
	@RequestMapping(produces = "application/json")
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody BaseServiceResponse handleConstraintViolationException(ConstraintViolationException ex) {
		BaseServiceResponse baseServiceResponse = new BaseServiceResponse();
		baseServiceResponse.setFieldError(FieldError.getErrors(ex.getConstraintViolations()));
		return baseServiceResponse;
	}
}