
package com.tmobile.error.base.domain.shared;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * This Holds a field or form error.
 * </p>
 * .
 *
 * @author Arun Kishor
 * @project magenta-error-core
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: Arun Kishor
 */
public class FieldError {

    /**
     * Converts a set of ConstraintViolations to a list of FieldErrors.
     *
     * @param constraintViolations
     *            the constraint violations
     * @return the errors
     */
    public static List<FieldError> getErrors( Set<ConstraintViolation<?>> constraintViolations) {

        return constraintViolations.stream().map(FieldError::of).collect(Collectors.toList());
    }

    /**
     * Converts a ConstraintViolation to a FieldError.
     *
     * @param constraintViolation
     *            the constraint violation
     * @return the field error
     */
    private static FieldError of( ConstraintViolation<?> constraintViolation) {

        // Get the field name by removing the first part of the propertyPath.
        // (The first part would be the service method name)
        String field = StringUtils.substringAfterLast(constraintViolation.getPropertyPath().toString(), ".");

        return new FieldError(field, constraintViolation.getMessageTemplate(), constraintViolation.getMessage());
    }

    // Name of the field. Null in case of a form level error.
    /** The field. */
    private String field;

    // Error code. Typically the I18n message-code.
    /** The code. */
    private String code;

    // Error message
    /** The message. */
    private String message;

    /**
     * Sets the field.
     *
     * @param field
     *            the field
     */
    public void setField( String field) {
        this.field = field;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the code
     */
    public void setCode( String code) {
        this.code = code;
    }

    /**
     * Sets the message.
     *
     * @param message
     *            the message
     */
    public void setMessage( String message) {
        this.message = message;
    }

    /**
     * The Constructor.
     *
     * @param field
     *            the field
     * @param code
     *            the code
     * @param message
     *            the message
     */
    public FieldError( String field, String code, String message) {
        this.field = field;
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "FieldError {field=" + field + ", code=" + code + ", message=" + message + "}";
    }
}
