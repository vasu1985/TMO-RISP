
package com.tmobile.retailinventoryserialization.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * The Class BaseController.
 */
public class BaseController {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(BaseController.class);

    /**
     * Convert and send.
     *
     * @param ctx
     *            the ctx
     * @param queueName
     *            the queue name
     * @param obj
     *            the obj
     * @return the rabbit template
     */
    public RabbitTemplate convertAndSend( ApplicationContext ctx, String queueName, Object obj) {
        RabbitTemplate rabbitTemplate = null;
        try {
            rabbitTemplate = ctx.getBean(RabbitTemplate.class);
            rabbitTemplate.setQueue(queueName);
            rabbitTemplate.convertAndSend(queueName, obj);
        } catch (BeansException e) {
            log.error(e.getMessage() + e.getCause());
        } catch (AmqpException e) {
            log.error(e.getMessage() + e.getCause());
        }
        return rabbitTemplate;
    }
}
