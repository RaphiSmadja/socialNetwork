package com.social.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages={"com.social.springwebapp.services.mapper"})
public class SpringwebappApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringwebappConfig.class);
		SpringApplication.run(SpringwebappApplication.class, args);
	}

}
