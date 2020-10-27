/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.receive.gateway.common.service;

import com.vnsw.receive.gateway.helper.RabbitMQInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phong84NV
 */
@Service("rabbitMQService")
public class RabbitMQServiceImpl implements RabbitMQService {

    @Autowired
    private Environment environment;

    @Override
    public RabbitMQInfo getRabbitMQLogInfo() {
        return new RabbitMQInfo(environment.getProperty("activemq.host"), environment.getProperty("activemq.virtualHost"),
                environment.getProperty("activemq.user"), environment.getProperty("activemq.password"), environment.getProperty("activemq.exchangeName"),
                environment.getProperty("activemq.queueLogName"), environment.getProperty("activemq.routingLogKey"), environment.getProperty("activemq.port"));
    }

    @Override
    public RabbitMQInfo getRabbitMQErrorInfo() {
        return new RabbitMQInfo(environment.getProperty("activemq.host"), environment.getProperty("activemq.virtualHost"),
                environment.getProperty("activemq.user"), environment.getProperty("activemq.password"), environment.getProperty("activemq.exchangeName"),
                environment.getProperty("activemq.queueErrName"), environment.getProperty("activemq.routingErrKey"), environment.getProperty("activemq.port"));
    }

}
