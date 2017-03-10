
package com.tmobile.retailinventoryservice;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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
public class QueryApp {

	final static String queueName = "state-updated";
	private CountDownLatch latch = new CountDownLatch(1);

	public void consumeMessage(String message) {
		System.out.println("Consumed <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		container.setDefaultRequeueRejected(false);
		container.setMissingQueuesFatal(false);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Consumer consumer) {
		return new MessageListenerAdapter(consumer, "consumeMessage");
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		SpringApplication.run(QueryApp.class, args);
	}

}
