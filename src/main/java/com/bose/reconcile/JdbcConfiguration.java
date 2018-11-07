package com.bose.reconcile;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JdbcConfiguration.class);
    
    @Bean(name = "dsDestination")
    public DataSource destinationDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2integrationdburl"));
        dataSource.setUsername(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2integrationdbusername"));
        dataSource.setPassword(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2integrationdbpassword"));
 
        return dataSource;
    }

    @Bean(name = "jdbcDestination")
    @Autowired
    public JdbcTemplate destinationJdbcTemplate(@Qualifier("dsDestination") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dsSource")
    public DataSource sourceDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        
        /*
        log.error("MY_ENV: " + System.getenv("MY_ENV"));
        log.error("eco2statedburl: " + EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedburl"));
        log.error("eco2statedbusername: " + EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedbusername"));
        log.error("eco2statedbpw: " + EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedbpw"));
        */
        
        dataSource.setUrl(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedburl"));
        dataSource.setUsername(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedbusername"));
        dataSource.setPassword(EnvironmentConfigUtil.getEnvironmentConfigSetting("eco2statedbpw"));
 
        return dataSource;
    }

    
    @Bean(name = "jdbcSource")
    @Autowired
    public JdbcTemplate sourceJdbcTemplate(@Qualifier("dsSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

