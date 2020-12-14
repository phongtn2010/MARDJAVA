/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.service;

import com.nsw.helper.RabbitMQInfo;
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
    public RabbitMQInfo getRabbitMQInfo() {
        return new RabbitMQInfo(environment.getProperty("activemq.host"), environment.getProperty("activemq.virtualHost"),
                environment.getProperty("activemq.user"), environment.getProperty("activemq.password"), environment.getProperty("activemq.exchangeName"),
                environment.getProperty("activemq.queueName"), environment.getProperty("activemq.routingKey"), environment.getProperty("activemq.port"));
    }

}
