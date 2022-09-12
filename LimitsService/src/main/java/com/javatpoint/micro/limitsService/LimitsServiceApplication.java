package com.javatpoint.micro.limitsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javatpoint.micro.dependencyInjection.Laptop; 
@EnableConfigServer

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.javatpoint.micro")
@SpringBootApplication
public class LimitsServiceApplication {

	public static void main(String[] args) {
		 
		
		ConfigurableApplicationContext context = SpringApplication.run(LimitsServiceApplication.class, args);
  Laptop l = context.getBean(Laptop.class);
 	l.print();
	}

}
