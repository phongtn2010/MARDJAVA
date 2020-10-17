/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.helper;

import com.nsw.service.RabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Mard10Helper {
private static final String TAG = "mard10Helper";
    final Logger logger = LoggerFactory.getLogger(Mard10Helper.class);
    
    @Autowired
    RabbitMQService rabbitMQService;
}
