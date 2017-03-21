
package com.tmobile.retailinventorycommandservice.exception;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.StringUtils;

/**
 * Holds a field or form error
 *
 * @author Arun Kishor
 */
public class FieldError {

    /**
     * Converts a set of ConstraintViolations to a list of FieldErrors
     *
     * @param constraintViolations
     */
    public static List<FieldError> getErrors( Set<ConstraintViolation<?>> constraintViolations) {

        return constraintViolations.stream().map(FieldError::of).collect(Collectors.toList());
    }

    /**
     * Converts a ConstraintViolation to a FieldError
     */
    private static FieldError of( ConstraintViolation<?> constraintViolation) {

        // Get the field name by removing the first part of the propertyPath.
        // (The first part would be the service method name)
        String field = StringUtils.substringAfterLast(constraintViolation.getPropertyPath().toString(), ".");

        return new FieldError(field, constraintViolation.getMessageTemplate(), constraintViolation.getMessage());
    }

    // Name of the field. Null in case of a form level error.
    private final String field;

    // Error code. Typically the I18n message-code.
    private final String code;

    // Error message
    private final String message;

    public FieldError( String field, String code, String message) {
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FieldError {field=" + field + ", code=" + code + ", message=" + message + "}";
    }
}
