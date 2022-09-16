package com.example.demo.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	
	
	private String  message ;
	private String  details ;
	private LocalDateTime timeStamp   ;
	public ErrorDetails( LocalDateTime timeStamp, String message, String details) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
