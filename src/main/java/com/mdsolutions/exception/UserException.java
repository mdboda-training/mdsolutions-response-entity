package com.mdsolutions.exception;

import org.springframework.http.HttpStatus;

public class UserException extends Exception{

	private String message;
	private HttpStatus status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + ", status=" + status + "]";
	}

	public UserException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public UserException() {
	}

}
