/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.controller;

import com.nsw.moh.constant.MOH07Constant;
import com.nsw.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */

@Controller
@RequestMapping(MOH07Constant.Routes.ROOT)
public class MOH07Controller {
    @Autowired
    Environment environment;
    @Autowired
    RabbitMQService rabbitMQService;
}
