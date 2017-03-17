
package com.tmobile.retailinventoryservice;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The Class QueryApp.
 */
@SpringBootApplication
public class QueryApp {

    /** The Constant queueName. */
    final static String queueName = "imei-state-updated";

    /**
     * Container.
     *
     * @param connectionFactory
     *            the connection factory
     * @param listenerAdapter
     *            the listener adapter
     * @return the simple message listener container
     */
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

    /**
     * Listener adapter.
     *
     * @param consumer
     *            the consumer
     * @return the message listener adapter
     */
    @Bean
    MessageListenerAdapter listenerAdapter( Consumer consumer) {
        return new MessageListenerAdapter(consumer, "consumeMessage");
    }

    /**
     * The main method.
     *
     * @param args
     *            the args
     */
    public static void main( String[] args) {
        SpringApplication.run(QueryApp.class, args);
    }

}
