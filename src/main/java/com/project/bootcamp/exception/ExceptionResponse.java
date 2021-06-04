package com.project.bootcamp.exception;

public class ExceptionResponse {

	private String message;

	ExceptionResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}