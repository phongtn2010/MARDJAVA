/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Phong84NV
 */
public class RabbitMQErrorHelper {

    public static final Logger logger = LoggerFactory.getLogger(RabbitMQErrorHelper.class);

    public static void pushLogToRabbitMQ(String log, RabbitMQInfo info) {
        logger.error(log);
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost(info.getHost());
//        factory.setUsername(info.getUserName());
//        factory.setPassword(info.getPassword());
//        factory.setVirtualHost(info.getVirtualHost());
//        factory.setPort(Integer.parseInt(info.getPort()));
//        try (Connection connection = factory.newConnection()) {
//            Channel channel = connection.createChannel();
//            channel.exchangeDeclare(info.getExchangeName(), "topic", true, false, null);
//            channel.queueDeclare(info.getQueueName(), true, false, false, null);
//            channel.basicPublish(info.getExchangeName(), info.getRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, log.getBytes("UTF-8"));
//            channel.close();
//        } catch (Exception ex) {
//            logger.error(ex.toString());
//        }
    }
}
