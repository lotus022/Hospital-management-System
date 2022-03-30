package com.cg.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import org.springframework.http.HttpStatus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exceptionhandling {
	
	Logger logger = LoggerFactory.getLogger(Exceptionhandling.class);
	@ExceptionHandler(AmbulanceNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(AmbulanceNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ErrorDetails response = new ErrorDetails();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
		return entity;
	}

}
