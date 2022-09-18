package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRest {
	
	private MessageSource ms;
	
	public HelloWorldRest(MessageSource ms1) {
		this.ms = ms1;
	}
	
	@GetMapping("/hello")
	public String getName() {
		System.out.println("this is hello method");
		return "Hello World";
	}
	
	@GetMapping("/hello2")
	public List<String> helloUser2() {
		List<String> ll = new ArrayList<String>();
		ll.add("user1");
		ll.add("user2");
		ll.add("user3");
		ll.add("user4");
		ll.add("user5");
		ll.add("user6");		
		return ll;
	}

	@GetMapping("/hello/{user}")
	public String helloUser(@PathVariable String user) {
		return "Hello World  : "+user;
	}
	
	
	
	@GetMapping("/helloIn")
	public String helloUserInterNational() {		
		Locale lx = LocaleContextHolder.getLocale();
		return ms.getMessage("good.morning.message", null, "Default Message", lx);
	}

}
