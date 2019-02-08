package com.ramesh.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Ramesh.Yaleru
 *
 */
@SpringBootApplication (scanBasePackages = "com.ramesh.*")
@EnableJpaRepositories("com.ramesh.*")
@EntityScan( basePackages = {"com.ramesh.*"} )
public class PinGenerateVerifyServiceApplication extends SpringBootServletInitializer{

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PinGenerateVerifyServiceApplication.class);
    }

	
	public static void main(String[] args) {
		SpringApplication.run(PinGenerateVerifyServiceApplication.class, args);
	}

	
}


