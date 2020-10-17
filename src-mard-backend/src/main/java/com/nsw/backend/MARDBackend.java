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
import com.nsw.backend.configuration.SwaggerConfig;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.WebApplicationInitializer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Import({JpaConfiguration.class, CorsConfig.class, ElasticsearchConfiguration.class, AspectPerformanceWatcher.class, SwaggerConfig.class})
@SpringBootApplication(scanBasePackages = {"com.nsw.backend"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching

public class MARDBackend extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MARDBackend.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MARDBackend.class, args);
        System.out.println("MARD Backend is running: Profile: " + AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7:00"));
    }
}
