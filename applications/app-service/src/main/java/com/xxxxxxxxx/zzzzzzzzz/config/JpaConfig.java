package com.xxxxxxxxx.zzzzzzzzz.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JpaConfig {
	
	@Bean
    public DataSource getDataSource() {    	
    	HikariConfig config = new HikariConfig();
    	config.setDriverClassName(org.postgresql.Driver.class.getName());
    	config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Papapa12345678");
    	config.setUsername("postgres");
        config.setPassword("Papapa12345678");
    	config.setSchema("horusddb");                
        return new HikariDataSource(config);
    }
    
}