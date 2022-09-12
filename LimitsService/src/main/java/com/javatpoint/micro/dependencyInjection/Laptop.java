package com.javatpoint.micro.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component 
public class Laptop {
	
	@Autowired
	HardDrive hd;
	
	public void print() {
		System.out.println("Testttttttt");
		hd.testHD();
	}
}
