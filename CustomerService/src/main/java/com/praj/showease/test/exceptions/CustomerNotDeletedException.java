package com.praj.showease.test.exceptions;

@SuppressWarnings("serial")
public class CustomerNotDeletedException extends RuntimeException{

	private String Message;

	public CustomerNotDeletedException(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	
	
	
}
