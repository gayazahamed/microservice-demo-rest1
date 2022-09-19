package com.config.server.confServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class ConfServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfServerApplication.class, args);
	}

}
