package com.jpa.test.jpademo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.jpademo.entity.User;
import com.jpa.test.jpademo.service.UserRepository;

@SpringBootApplication
public class JpademoApplication {
	
	private static final Logger log = 
			LoggerFactory.getLogger(JpademoApplication.class);
	
	@Autowired
	private   UserRepository userRepository;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JpademoApplication.class, args);
		
		 UserRepository userRepository = run.getBean(UserRepository.class);
		Optional<User> userWithIdOne = userRepository.findById(2L);
		log.info("@@@@@@@@ User is retrived : " + userWithIdOne);
	}

	 
}
