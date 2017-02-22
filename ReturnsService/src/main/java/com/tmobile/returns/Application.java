
package com.tmobile.returns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * This is the CLASS Application for the Returns microservice which enables
 * Spring Boot
 * </p>
 * .
 *
 * @author AB00334861
 * @project RISP
 */
@SpringBootApplication
// @EnableDiscoveryClient
public class Application {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
