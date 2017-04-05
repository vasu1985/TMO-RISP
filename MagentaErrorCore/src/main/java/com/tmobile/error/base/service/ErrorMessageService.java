
package com.tmobile.error.base.service;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.error.base.domain.shared.ErrorMessage;
import com.tmobile.error.base.repository.ErrorMessageRepository;

/**
 * <p>
 * This class is responsible for returning messages based on error code.
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
@Service
public class ErrorMessageService {

    public ErrorMessageService() {

    }

    /** The error repository. */
    @Autowired
    ErrorMessageRepository errorRepository;

    /** The env. */
    Properties             env   = new Properties();

    /** The input. */
    InputStream            input = null;

    /**
     * Sets the proxy.
     */
    private void setProxy() {
        System.setProperty("http.proxyHost", "10.13.125.14");
        System.setProperty("http.proxyPort", String.valueOf(8080));

        System.setProperty("https.proxyHost", "10.13.125.14");
        System.setProperty("https.proxyPort", String.valueOf(8080));
    }

    /**
     * Generate error message.
     *
     * @param error_code
     *            the error_code
     * @return the string
     */
    public String getErrorMessage( final int error_code) {
        ErrorMessage result = errorRepository.findByErrorCode(error_code);
        System.out.println("the error ssssrepositpoty si" + result);

        System.out.println(" the result message is +" + result.getError_message());

        String message = result.getError_message();

        return message;
    }

    public void updateErrorMessage() {

        ErrorMessage errorbad = new ErrorMessage(400, "BAD request...");
        ErrorMessage errornotauth = new ErrorMessage(401, "Un Authorized....");
        ErrorMessage errornotvalid = new ErrorMessage(405, "Not Supported....");
        ErrorMessage errornotFound = new ErrorMessage(404, "Page Not found...");
        ErrorMessage errorserver = new ErrorMessage(500, "Internal server error..");

        errorRepository.save(errorbad);
        errorRepository.save(errornotFound);
        errorRepository.save(errorserver);
        errorRepository.save(errornotvalid);
        errorRepository.save(errornotauth);

    }
}