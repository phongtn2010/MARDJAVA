/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.nsw.common.model.SignData;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Phong84NV
 */
public class RabbitMQHelper {

    public static final Logger logger = LoggerFactory.getLogger(RabbitMQHelper.class);
    /**
     * Push Error Log to RabbitMQ
     * @param log
     * @param info
     */
    public static void pushLogToRabbitMQ(String log, RabbitMQInfo info){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(info.getHost());
        factory.setUsername(info.getUserName());
        factory.setPassword(info.getPassword());
        factory.setVirtualHost(info.getVirtualHost());
        factory.setPort(Integer.parseInt(info.getPort()));
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(info.getExchangeName(), "topic", true, false, null);
            channel.queueDeclare(info.getQueueName(), true, false, false, null);
            channel.basicPublish(info.getExchangeName(), info.getRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, log.getBytes("UTF-8"));
            channel.close();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
        }
    }
    /**
     * Push sign request to RabbitMQ
     * @param data
     * @param info
     */
    public static void pushSignReqToRabbitMQ(SignData data, RabbitMQInfo info){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(info.getHost());
        factory.setUsername(info.getUserName());
        factory.setPassword(info.getPassword());
        factory.setVirtualHost(info.getVirtualHost());
        factory.setPort(Integer.parseInt(info.getPort()));
        //"MST{}fiDocumentCode{}fiXml{}fiFunc{}fiMsgType{}fiMinistryCode{}fiDocumentId{}fiDocumentType{}fiData"
        String dataSigned = data.getTaxCode() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH  + data.getFiDocumentCode() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + 
                data.getFiXml() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getFiFunc() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getFiMsgType() +
                Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getMinistryCode() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getFiDocumentId() + 
                Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getFiDocumentType() + Constants.MESSAGE_SEPARATOR_WITHOUT_FLASH + data.getFiData();
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(info.getExchangeName(), "topic", true, false, null);
            channel.queueDeclare(info.getQueueName(), true, false, false, null);
            channel.basicPublish(info.getExchangeName(), info.getRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, dataSigned.getBytes("UTF-8"));
            channel.close();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
        }
    }
    
    /**
     * Push completed sign data to RabbitMQ
     * @param data
     * @param info
     */
    public static void pushSignDoneToRabbitMQ(SignData data, RabbitMQInfo info){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(info.getHost());
        factory.setUsername(info.getUserName());
        factory.setPassword(info.getPassword());
        factory.setVirtualHost(info.getVirtualHost());
        factory.setPort(Integer.parseInt(info.getPort()));
        //"MST{}fiDocumentCode{}fiXml{}fiFunc{}fiMsgType{}fiMinistryCode{}fiDocumentId{}fiDocumentType"
        String dataSigned = data.getTaxCode() + Constants.MESSAGE_SEPARATOR  + data.getFiDocumentCode() + Constants.MESSAGE_SEPARATOR + 
                data.getFiXml() + Constants.MESSAGE_SEPARATOR + data.getFiFunc() + Constants.MESSAGE_SEPARATOR + data.getFiMsgType() +
                Constants.MESSAGE_SEPARATOR + data.getMinistryCode() + Constants.MESSAGE_SEPARATOR + data.getFiDocumentId() + 
                Constants.MESSAGE_SEPARATOR + data.getFiDocumentType();
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(info.getExchangeName(), "topic", true, false, null);
            channel.queueDeclare(info.getQueueName(), true, false, false, null);
            channel.basicPublish(info.getExchangeName(), info.getRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, dataSigned.getBytes("UTF-8"));
            channel.close();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
        }
    }
}
