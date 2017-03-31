
package com.tmobile.retailinventoryserialization.command.device.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.error.base.controller.BaseErrorController;
import com.tmobile.error.base.domain.shared.CustomErrorResponse;

/**
 * The Class ServiceErrorController. This class handles single point exception handler for EccommerceService Module. .
 */

@ControllerAdvice
@RestController("/error")
public class ServiceErrorController extends BaseErrorController {
	/** The log. */
	private static Logger log = LoggerFactory.getLogger(ServiceErrorController.class);

	@RequestMapping("/error")
	@ExceptionHandler(Exception.class)
	public CustomErrorResponse processError(HttpServletRequest request, HttpServletResponse response, Exception ex) {

		log.info("Inside Service Controller");
		return super.processError(request, response, ex);
		
	}
	

	
    
   

}
