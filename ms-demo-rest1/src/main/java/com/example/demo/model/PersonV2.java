package com.example.demo.model;

public class PersonV2 {
	
	private String firstName;
	private String LastName;
	
	public PersonV2(String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.LastName = lastName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
