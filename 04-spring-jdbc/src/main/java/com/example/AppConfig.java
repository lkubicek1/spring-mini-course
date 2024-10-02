package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    /* This is actually not needed as Spring Boot will automatically configure the DataSource!

    @Bean
    public DataSource dataSource() {
       return DataSourceBuilder.create()
               .driverClassName("oracle.jdbc.driver.OracleDriver")
               .url("jdbc:oracle:thin:@localhost:1521:xe")
               .username("myuser")
               .password("mypassword")
               .build();
    }*/

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
