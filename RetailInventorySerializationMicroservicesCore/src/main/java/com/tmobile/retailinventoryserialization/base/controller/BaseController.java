package com.tmobile.retailinventoryserialization.base.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class BaseController {

	public RabbitTemplate convertAndSend(ApplicationContext ctx, String queueName, Object obj) {
		RabbitTemplate rabbitTemplate = null;
		try {
			rabbitTemplate = ctx.getBean(RabbitTemplate.class);
			rabbitTemplate.setQueue(queueName);
			rabbitTemplate.convertAndSend(queueName, obj);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmqpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rabbitTemplate;
	}
}
