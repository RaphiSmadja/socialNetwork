package com.social.springwebapp;

import com.social.springwebapp.ressources.UserRessource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class SpringwebappApplication {

	public static void main(String[] args) {
//		ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringwebappConfig.class);
		SpringApplication.run(SpringwebappApplication.class, args);
	}

}
