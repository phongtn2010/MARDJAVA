/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/**
 *
 * @author PhongNguyen
 */
public class MessageSourceHelper implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource ms) {
        this.messageSource = ms;
    }
}
