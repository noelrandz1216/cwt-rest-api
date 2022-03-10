package com.cwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleGlobalException(RuntimeException e) {
		
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
