package com.tmobile.retailinventoryserialization.base.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;

public class BaseController {

	public RabbitTemplate convertAndSend(ApplicationContext ctx, String queueName, Object obj) {
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
		rabbitTemplate.setQueue(queueName);
		rabbitTemplate.convertAndSend(queueName, obj);
		return rabbitTemplate;
	}
}
