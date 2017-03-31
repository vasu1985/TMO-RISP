/*
 * GlobalExceptionInterface
 */
package com.tmobile.error.base.domain.shared;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * This Interface contains common methods to be implemented for
 * BaseErrorController
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
public interface ErrorHandlerInterface {

	

	/**
	 * Process error.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param ex
	 *            the ex
	 * @return the custom http response
	 */
	public abstract CustomErrorResponse processError(HttpServletRequest request, HttpServletResponse response,
			Exception ex);

}
