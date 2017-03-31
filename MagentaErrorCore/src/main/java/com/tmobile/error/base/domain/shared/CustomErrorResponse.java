/*
 * CustomErrorResponse
 */

package com.tmobile.error.base.domain.shared;

/**
 * <p>
 * This class represents an HTTP error object
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */

public class CustomErrorResponse {

	/** The exception. */
	private String exception;

	/** The message. */
	private String message;

	/**
	 * The Constructor.
	 *
	 * @param pException
	 *            the p exception
	 * @param pMessage
	 *            the p message
	 */
	public CustomErrorResponse(String pException, String pMessage) {
		this.exception = pException;
		this.message = pMessage;
	}

	/**
	 * Gets the value of exception.
	 *
	 * @return returns the property exception
	 */

	public String getException() {

		return exception;
	}

	/**
	 * Sets the value of property exception with value exception.
	 *
	 * @param exception
	 *            the exception to set
	 */

	public void setException(String exception) {
		this.exception = exception;
	}

	/**
	 * Gets the value of message.
	 *
	 * @return returns the property message
	 */

	public String getMessage() {

		return message;
	}

	/**
	 * Sets the value of property message with value message.
	 *
	 * @param message
	 *            the message to set
	 */

	public void setMessage(String message) {
		this.message = message;
	}

}
