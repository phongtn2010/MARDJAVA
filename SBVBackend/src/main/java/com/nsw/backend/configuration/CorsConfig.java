/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Phong84NV
 */
@Configuration
public class CorsConfig {
	@Bean
	public FilterRegistrationBean corsFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new CORSFilter());
		bean.setOrder(0);
		return bean;
	}	
}
