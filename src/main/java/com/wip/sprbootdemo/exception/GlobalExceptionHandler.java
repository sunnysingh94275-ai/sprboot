package com.wip.sprbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiError> handleEmployeeNotFound(EmployeeNotFoundException ex) {

		ApiError error = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ApiError> handleDepartmentNotFoundException(DepartmentNotFoundException ex) {

		ApiError error = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleAnyException(Exception ex) {

		ApiError error = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
