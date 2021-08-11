package com.xxxxxxxxx.zzzzzzzzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * MainApplication  causacion Y pagos
 * @author causacionYpagos
 *
 */
@SpringBootApplication
@ComponentScan(basePackages 		= "com.xxxxxxxxx")
@EnableJpaRepositories(basePackages = "com.xxxxxxxxx")
@EntityScan(basePackages 			= "com.xxxxxxxxx")
public class MainApplication {

	/**
	 * main
	 * @param args args . . . 
	 */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }
}


