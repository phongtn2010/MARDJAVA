package com.vnsw.receive.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import com.vnsw.receive.gateway.configuration.WebServiceConfig;
import org.springframework.web.WebApplicationInitializer;

@Import({WebServiceConfig.class})
@SpringBootApplication(scanBasePackages = {"com.vnsw"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching
public class VNSWGateway extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VNSWGateway.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(VNSWGateway.class, args);
        System.out.println("Receive Gateway is runing!");
    }
}
