package com.cwt.exceptions;


/*******
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getObjectName() + ":  " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid data", errors);

		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = ex.getParameterName() + " parameter is missing";

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@SuppressWarnings("unused")
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String error = "An error occurred.";

		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occurred", error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

	}

	@SuppressWarnings("unused")
	@ExceptionHandler({ NoSuchElementException.class })
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {

		String error = "The customer does not exist.";

		if (error == null) {
			error = "The customer does not exist.";
		}

		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid customer", error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

	}

	
	  @ExceptionHandler({ MethodArgumentNotValidException.class}) public
	  ResponseEntity<Object> handleMethodArgumentNotValidException(
	  MethodArgumentNotValidException ex, WebRequest request) {
	  
	  String error = "Validation errors.";
	  
	  ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
	  ex.getLocalizedMessage(), error); return new ResponseEntity<Object>(apiError,
	  new HttpHeaders(), apiError.getStatus());
	  
	  }
	 

	@SuppressWarnings("unused")
	@ExceptionHandler({ ValidationException.class })
	public ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request) {

		String error = "Validation error";

		if (error == null) {
			error = "Validation errors.";
		}

		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {

		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

	}

}
*****/
