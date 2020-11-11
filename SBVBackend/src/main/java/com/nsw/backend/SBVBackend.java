package com.nsw.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import com.nsw.backend.configuration.AspectPerformanceWatcher;
import com.nsw.backend.configuration.CorsConfig;
import com.nsw.backend.configuration.ElasticsearchConfiguration;
import com.nsw.backend.configuration.JpaConfiguration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.WebApplicationInitializer;


@Import({JpaConfiguration.class, CorsConfig.class, ElasticsearchConfiguration.class, AspectPerformanceWatcher.class})
@SpringBootApplication(scanBasePackages = {"com.nsw.backend"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching

public class SBVBackend extends SpringBootServletInitializer implements WebApplicationInitializer  {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SBVBackend.class);
    }

    public static void main(String[] args) {
    	SpringApplication.run(SBVBackend.class, args);
        System.out.println("MONRE Backend is running: Profile: " + AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
    }
}
