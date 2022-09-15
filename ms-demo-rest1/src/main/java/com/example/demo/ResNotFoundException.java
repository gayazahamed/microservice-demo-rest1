package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResNotFoundException extends Exception {
	
	public ResNotFoundException() {
		
	}
	public ResNotFoundException(String msg) {
	super(msg);	
	}

}