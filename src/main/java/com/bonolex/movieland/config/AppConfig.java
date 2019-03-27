package com.bonolex.movieland.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.bonolex.movieland")
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource(@Value("${jdbc.driver}") String driverName,
                                    @Value("${jdbc.url}") String url,
                                    @Value("${jdbc.username}") String username,
                                    @Value("${jdbc.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
