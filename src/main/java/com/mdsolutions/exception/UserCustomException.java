package com.mdsolutions.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserCustomException extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		UserException exception = new UserException("pathVarable is missing", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		UserException exception = new UserException("requestParam is missing", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		UserException exception = new UserException("Resource not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
	}

}
