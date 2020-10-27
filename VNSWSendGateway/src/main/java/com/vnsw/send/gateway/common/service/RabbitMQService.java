package com.vnsw.send.gateway.common.service;

import com.vnsw.send.gateway.helper.RabbitMQInfo;

/**
 *
 * @author Phongnv9
 */
public interface RabbitMQService {

    RabbitMQInfo getRabbitMQLogInfo(); 
    RabbitMQInfo getRabbitMQErrorInfo(); 
}
