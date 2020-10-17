/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.configuration;

import com.nsw.constant.AppConstant;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 *
 * @author QUANGNV18
 */
@Configuration
public class ErrorPagesServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer cesc) {
        cesc.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, AppConstant.ControllerURI.NOTFOUND));
        cesc.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, AppConstant.ControllerURI.NOTFOUND));
        cesc.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, AppConstant.ControllerURI.NOTFOUND));
        cesc.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, AppConstant.ControllerURI.NOTFOUND));
        cesc.addErrorPages(new ErrorPage(Exception.class, AppConstant.ControllerURI.ERROR));
    }

}
