package com.vnsw.receive.gateway.common.service;

import com.vnsw.receive.gateway.helper.RabbitMQInfo;

/**
 *
 * @author Phongnv9
 */
public interface RabbitMQService {

    RabbitMQInfo getRabbitMQLogInfo(); 
    RabbitMQInfo getRabbitMQErrorInfo(); 
}
