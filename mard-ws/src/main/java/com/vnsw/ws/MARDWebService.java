package com.vnsw.ws;

import com.vnsw.ws.configuration.SwaggerConfig;
import com.vnsw.ws.configuration.WebServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.web.WebApplicationInitializer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Import({WebServiceConfig.class, SwaggerConfig.class})
@SpringBootApplication(scanBasePackages = {"com.vnsw"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching
public class MARDWebService extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MARDWebService.class, args);
        System.out.println("MARD Web Services is running");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MARDWebService.class);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7:00"));
    }

}
