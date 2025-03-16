package com.praj.showease.test.feed.exceptions;

@SuppressWarnings("serial")
public class FeedBackNotFoundException extends RuntimeException{

	private String message;

	public FeedBackNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
