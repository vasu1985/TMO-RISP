
package com.tmobile.error.base.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tmobile.error.base.domain.shared.CustomErrorResponse;
import com.tmobile.error.base.domain.shared.ErrorHandlerInterface;
import com.tmobile.error.base.domain.shared.FieldError;
import com.tmobile.error.base.service.ErrorMessageService;

/**
 * <p>
 * This class defines methods for handling error thrown by parent services using error core project.
 * </p>
 * .
 *
 * @author vm00436370
 * @project magenta-error-core
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
@RestController
public class BaseErrorController implements ErrorHandlerInterface, ErrorController {

    /** The log. */
    private static Logger       log       = LoggerFactory.getLogger(BaseErrorController.class);

    /** The error attributes. */
    @Autowired
    private ErrorAttributes     errorAttributes;

    /** The Constant PATH. */
    public static final String  PATH      = "/error";

    /** The Constant ERROR. */
    public static final String  STR_ERROR = "error";

    /** The errorService. */
    @Autowired
    private MessageSource       msgSource;

    /** The error service. */
    @Autowired
    private ErrorMessageService errorService;

    /*
     * (non-Javadoc)
     * @see com.tmobile.error.base.ErrorHandlerInterface#processError(javax.servlet. http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Exception)
     */

    @Override
    @ExceptionHandler( Exception.class)
    public CustomErrorResponse processError( HttpServletRequest request, HttpServletResponse response, Exception ex) {

        // Get the Http error code.
        // final int error_code = getHttpStatusCode(request);

        // Generates Error message for corresponding Http Error Code.

        RequestAttributes requestAttributes = new ServletRequestAttributes(request, response);
        Map<String, Object> error = errorAttributes.getErrorAttributes(requestAttributes, true);

        int statusCode = (Integer) error.get("status");
        String exception = (String) error.get("exception");

        if (ex instanceof HttpClientErrorException) {
            statusCode = ((HttpClientErrorException) ex).getStatusCode().value();
            exception = ((HttpClientErrorException) ex).getMessage();
        }
        errorService.updateErrorMessage();
        final String error_message = errorService.getErrorMessage(statusCode);

        CustomErrorResponse errorResp = new CustomErrorResponse(exception, error_message);

        return errorResp;

    }

    /**
     * Handle constraint violation exception.
     *
     * @param ex
     *            the ex
     * @return the list< custom error response>
     */
    @ExceptionHandler( ConstraintViolationException.class)
    public List<CustomErrorResponse> handleConstraintViolationException( ConstraintViolationException ex) {

        Locale currentLocale = LocaleContextHolder.getLocale();
        List<CustomErrorResponse> errorList = new ArrayList<CustomErrorResponse>();
        List<FieldError> errors = FieldError.getErrors(ex.getConstraintViolations());
        for ( int i = 0; i < errors.size(); i++) {
            FieldError error = errors.get(i);
            error.setMessage(msgSource.getMessage(error.getMessage(), null, currentLocale));
            CustomErrorResponse errorResp = new CustomErrorResponse(ex.getMessage(), error.getMessage());
            errorList.add(errorResp);
        }

        return errorList;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
     */
    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return PATH;
    }

}
