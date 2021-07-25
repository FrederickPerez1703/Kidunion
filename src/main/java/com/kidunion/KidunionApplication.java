package com.kidunion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@EnableAutoConfiguration
public class KidunionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(KidunionApplication.class, args);
	}

}

