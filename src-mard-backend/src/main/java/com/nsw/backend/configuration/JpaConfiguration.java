package com.nsw.backend.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.nsw.backend.mard.p01.repositories",
        "com.nsw.backend.mard.p06.repositories",
        "com.nsw.backend.mard.p07.repositories",
        "com.nsw.backend.mard.p08.repositories",
        "com.nsw.backend.mard.p09.repositories",
        "com.nsw.backend.dic.repositories",

        "com.nsw.backend.mard.p25.repositories"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
//@EnableElasticsearchRepositories("com.nsw.backend.repositories.search")
public class JpaConfiguration {

    @Autowired
    private Environment environment;

    @Value("${datasource.MARDBackend.maxPoolSize:50}")
    private int maxPoolSize;

    @Value("${datasource.MARDBackend.idleTimeout:60000}") // Client timeout when request connection 60s
    private int idleTimeout;

    @Value("${datasource.MARDBackend.maxLifetime:1200000}") // Idle time in pool 20m
    private int maxLifetime;

    /*
	 * Populate SpringBoot DataSourceProperties object directly from application.yml 
	 * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
	 * properties of DataSourceProperties object].
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.MARDBackend")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    /*
	Configure HikariCP pooled DataSource.
     */
    @Bean
    public DataSource dataSource() {
        DataSourceProperties dataSourceProperties = dataSourceProperties();
        HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
                .create(dataSourceProperties.getClassLoader())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .type(HikariDataSource.class)
                .build();
        dataSource.setMaxLifetime(maxLifetime);
        dataSource.setIdleTimeout(idleTimeout);
        dataSource.setMaximumPoolSize(maxPoolSize);
        return dataSource;
    }

    /*
	 * Entity Manager Factory setup.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[]{
            "com.nsw.backend.mard.p01.model",
            "com.nsw.backend.mard.p06.model",
            "com.nsw.backend.mard.p07.model",
			"com.nsw.backend.mard.p08.model",
			"com.nsw.backend.mard.p09.model",
            "com.nsw.backend.mard.p10.model",
           	"com.nsw.backend.mard.p11.model",
            "com.nsw.backend.mard.p12.model", 
            "com.nsw.backend.dic.model",
            "com.nsw.backend.mard.p25.model"});
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }

    /*
	 * Provider specific adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    /*
	 * Here you can specify any provider specific properties.
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("datasource.MARDBackend.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("datasource.MARDBackend.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("datasource.MARDBackend.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("datasource.MARDBackend.hibernate.format_sql"));
        if (StringUtils.isNotEmpty(environment.getRequiredProperty("datasource.MARDBackend.defaultSchema"))) {
            properties.put("hibernate.default_schema", environment.getRequiredProperty("datasource.MARDBackend.defaultSchema"));
        }
        return properties;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}
