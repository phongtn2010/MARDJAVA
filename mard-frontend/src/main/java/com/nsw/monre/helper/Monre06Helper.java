/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.helper;

import com.nsw.service.RabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AnPhucNguyen
 */
public class Monre06Helper {
private static final String TAG = "Monre06Helper";
    final Logger logger = LoggerFactory.getLogger(Monre06Helper.class);
    
    @Autowired
    RabbitMQService rabbitMQService;
}
