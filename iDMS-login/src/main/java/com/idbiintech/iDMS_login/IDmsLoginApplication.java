package com.idbiintech.iDMS_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IDmsLoginApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IDmsLoginApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(IDmsLoginApplication.class, args);
	}

}
