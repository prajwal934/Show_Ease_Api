package com.praj.showease.test.exceptions;

@SuppressWarnings("serial")
public class CustomerNotFoundByIdException extends RuntimeException {
	
	private String message;

	public CustomerNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
