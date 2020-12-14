/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong84NV
 */
public class RabbitMQErrorHelper {

    public static void pushLogToRabbitMQ(String log, RabbitMQInfo info) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(info.getHost());
        factory.setUsername(info.getUserName());
        factory.setPassword(info.getPassword());
        factory.setVirtualHost(info.getVirtualHost());
        factory.setPort(Integer.parseInt(info.getPort()));
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(info.getExchangeName(), "topic", true, false, null);
            channel.queueDeclare(info.getQueueName(), true, false, false, null);
            channel.basicPublish(info.getExchangeName(), info.getRoutingKey(), null, log.getBytes("UTF-8"));
            channel.close();
        } catch (IOException ex) {
            Logger.getLogger(RabbitMQErrorHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(RabbitMQErrorHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void pushLogToRabbitMQ(String errorInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
