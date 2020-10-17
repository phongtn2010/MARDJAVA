package com.nsw.service;

import com.nsw.helper.RabbitMQInfo;

/**
 *
 * @author Phongnv9
 */
public interface RabbitMQService {

    RabbitMQInfo getRabbitMQInfo(); 
    RabbitMQInfo getRabbitMQInfoForSignReq(String queueName); 
    RabbitMQInfo getRabbitMQInfoForSignDone(); 
}
