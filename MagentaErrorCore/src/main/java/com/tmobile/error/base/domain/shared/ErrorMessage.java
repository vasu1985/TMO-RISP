/*
 * ErrorMessage
 */
package com.tmobile.error.base.domain.shared;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 * <p>
 * This represents the ErrorMessage Bean including errormessage and error code.
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */

public class ErrorMessage implements Serializable {

	/**
	 * The Constructor.
	 */
	public ErrorMessage() {

	}

	/** The error code. */
	@Id
	public int errorCode;

	/** The error message. */
	public String errorMessage;

	/**
	 * The Constructor.
	 *
	 * @param error_code
	 *            the error_code
	 * @param error_message
	 *            the error_message
	 */
	@PersistenceConstructor
	public ErrorMessage(int error_code, String error_message) {
		this.errorMessage = error_message;
		this.errorCode = error_code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return errorCode + " : " + errorMessage;
	}

	/**
	 * Gets the error_code.
	 *
	 * @return the error_code
	 */
	public int getError_code() {
		return errorCode;
	}

	/**
	 * Sets the error_code.
	 *
	 * @param error_code
	 *            the error_code
	 */
	public void setError_code(int error_code) {
		this.errorCode = error_code;
	}

	/**
	 * Gets the error_message.
	 *
	 * @return the error_message
	 */
	public String getError_message() {
		return errorMessage;
	}

	/**
	 * Sets the error_message.
	 *
	 * @param error_message
	 *            the error_message
	 */
	public void setError_message(String error_message) {
		this.errorMessage = error_message;
	}

}