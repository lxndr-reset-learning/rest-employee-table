package com.reset.spring.rest.server.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.reset.spring.rest.server")
@PropertySource("classpath:server.properties")
public class ServerConfiguration extends WebMvcConfigurationSupport {

    @Value("${database.url}")
    private String databaseURL;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    @Value("${database.driver}")
    private String driverClassName;

    @Value("${database.validation.query}")
    private String validationQuery;

    private Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(databaseURL);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setTestWhileIdle(true);
        dataSource.setValidationQuery(validationQuery);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.reset.spring.rest.server.entity");
        Properties hibernateProperties = getHibernateProperties();
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }
}