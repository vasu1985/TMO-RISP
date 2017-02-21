package com.tmobile.ris.microservices.services.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ReceiveServer {

	public static void main(String[] args) {
		SpringApplication.run(ReceiveServer.class, args);
	}
}
