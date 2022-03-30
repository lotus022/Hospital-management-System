package com.cg.exception;

public class AppointmentException extends RuntimeException{
	   
	String message;
	public AppointmentException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
	
}