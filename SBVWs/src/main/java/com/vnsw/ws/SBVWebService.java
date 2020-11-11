package com.vnsw.ws;

import com.vnsw.ws.configuration.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import com.vnsw.ws.configuration.WebServiceConfig;
import org.springframework.web.WebApplicationInitializer;

@Import({WebServiceConfig.class, SwaggerConfig.class})
@SpringBootApplication(scanBasePackages = {"com.vnsw"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching
public class SBVWebService extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SBVWebService.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SBVWebService.class, args);
        System.out.println("SBV Web Services is running");
    }
}
