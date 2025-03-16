package com.praj.showease.movie.exceptions;

@SuppressWarnings("serial")
public class MovieNotFoundByIdException extends RuntimeException {
	
	private String message;

	public MovieNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
