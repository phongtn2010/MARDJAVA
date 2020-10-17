package com.nsw.configuration;

import com.nsw.converter.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.List;
import java.util.Locale;

@Configuration
//@Import({ AppWebSocketConfig.class, RabbitMQConfiguration.class })
@Import({AppWebSocketConfig.class})
//@Import({EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@EnableWebMvc
@ComponentScan(basePackages = "com.nsw")
@PropertySources(value = {
    @PropertySource("classpath:application.properties")
    ,
    @PropertySource("classpath:most_api.properties")
    ,
    @PropertySource("classpath:moh_api.properties")
    ,
    @PropertySource("classpath:mard_api.properties")
    ,
    @PropertySource("classpath:monre_api.properties")
    ,
    @PropertySource("classpath:moit_api.properties")
    ,
    @PropertySource("classpath:mt_api.properties")
    ,
    @PropertySource("classpath:bca_api.properties")
    ,
    @PropertySource("classpath:sbv_api.properties")
	,
	@PropertySource("classpath:mic_api.properties")
    })
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript
     * etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
    }

    /**
     * Configure Converter to be used. In our example, we need a converter to
     * convert string values[Roles] to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }

    /**
     * Optional. It's only required when handling '.' in @PathVariables which
     * otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164],
     * still present in Spring 4.1.7. This is a workaround for this issue.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }

    // Multil Language
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages",
                "classpath:most_01",
                "classpath:moh_06",
                "classpath:most_02",
                "classpath:mard",
                "classpath:mard_06",
                "classpath:mard_07",
                "classpath:mard_01",
                "classpath:mard_08",
                "classpath:mard_09",
                "classpath:mard_10",
                "classpath:mard_11",
                "classpath:most_03",
                "classpath:most_04",
                "classpath:most_05",
                "classpath:most_06",
                "classpath:monre_01",
                "classpath:monre_06",
                "classpath:monre_05",
                "classpath:monre_07",
                "classpath:monre_08",
                "classpath:monre_09",
                "classpath:sbv_01",
                "classpath:mt",
                "classpath:mt_13",
                "classpath:mt_36",
                "classpath:mt_37",
                "classpath:mt_41",
                "classpath:mt_42",
                "classpath:mt_43",
                "classpath:mt_44",
                "classpath:mt_58",
                "classpath:mt_61",
                "classpath:mt_qlpt",
                "classpath:moit_01",
                "classpath:moit_04",
                "classpath:moit_05",
                "classpath:moit_06",
                "classpath:moit_07",
                "classpath:bca_01",
                "classpath:bca_02",
                "classpath:moh_39",
                "classpath:mard_12",
                "classpath:mard_14",
                "classpath:mard_15",
                "classpath:mard_16",
                "classpath:moh_19",
                "classpath:moh_07",
				"classpath:moh_11",
				"classpath:moh_10",
                "classpath:moh_01",
				"classpath:moh_09",
				"classpath:mic_02",
                "classpath:mard_25"
				
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("vi"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
        // Theme
        /*
            ThemeChangeInterceptor themeInterceptor = new ThemeChangeInterceptor();
            themeInterceptor.setParamName("theme");
            registry.addInterceptor(themeInterceptor);*/
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setPrettyPrint(true);
        return mappingJackson2HttpMessageConverter;
    }

//    @Bean
//    public ObjectMapper getObjectMapper() {
//        JsonFactory jsonFactory = new JsonFactory();
//        ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // this is what you need
//        objectMapper.setSerializationInclusion(Include.NON_NULL); // this is to not serialize unset properties
//        return objectMapper;
//    }
    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter() {
        MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
        mappingJackson2XmlHttpMessageConverter.setPrettyPrint(true);
        return mappingJackson2XmlHttpMessageConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
        converters.add(mappingJackson2XmlHttpMessageConverter());
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(838860800l);
        resolver.setMaxInMemorySize(0);
        return resolver;
    }
}
