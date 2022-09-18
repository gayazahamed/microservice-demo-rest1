package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person1;
import com.example.demo.model.PersonV2;

@RestController
public class UserRestVersion2 {
	
	
	@GetMapping("/v1/person")
	public Person1 getPerson() {		
		return new Person1("Person1");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPerson2() {		
		return new PersonV2("First","Last");
	}
	
	@GetMapping(path="/person",params="version=1")
	public PersonV2 getFirstVersionPerson1() {		
		return new PersonV2("First1","Last1");
	}
	
	@GetMapping(path="/person" ,params="version=2")
	public PersonV2 getFirstVersionPerson2() {		
		return new PersonV2("First2","Last2");
	}

	
	@GetMapping(path="/person" ,headers="X-API-VERSION=1")
	public PersonV2 getPersonHeader() {		
		return new PersonV2("First1","Last1");
	}
	
	@GetMapping(path="/person" ,headers="X-API-VERSION=2")
	public PersonV2 getPersonHeader2() {		
		return new PersonV2("First2","Last2");
	}

}
