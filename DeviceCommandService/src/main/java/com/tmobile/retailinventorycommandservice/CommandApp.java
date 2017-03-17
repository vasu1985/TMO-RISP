
package com.tmobile.retailinventorycommandservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS Application
 * </p>
 * 
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:09:39 PM Author: SS00443175
 */
@SpringBootApplication
public class CommandApp {
	public final static String queueName = "imei-state-updated";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("device-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CommandApp.class, args);
	}

}
