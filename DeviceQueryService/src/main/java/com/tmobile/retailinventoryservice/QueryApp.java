
package com.tmobile.retailinventoryservice;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueryApp {

    final static String queueName = "device-updated";

    @Bean
    SimpleMessageListenerContainer container( ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        container.setDefaultRequeueRejected(false);
        container.setMissingQueuesFatal(false);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter( Consumer consumer) {
        return new MessageListenerAdapter(consumer, "consumeMessage");
    }

    public static void main( String[] args) {
        SpringApplication.run(QueryApp.class, args);
    }

}
