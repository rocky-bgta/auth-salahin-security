
package com.auth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // Configure your data source properties here
    private static final String DRIVER_CLASS_NAME ="com.mysql.cj.jdbc.Driver"; //"${jdbc.driverClassName}";
    private static final String URL = "jdbc:mysql://localhost:3306/casheqa"; //"${jdbc.url}";
    private static final String USERNAME = "root";//"${jdbc.username}";
    private static final String PASSWORD = "root";// "${jdbc.password}";


    @Bean(name = "vcasheDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}

