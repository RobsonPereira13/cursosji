package com.robsondev.cursosji.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.robsondev.cursosji.services.exceptions.ObjectNotFoundExeception;

@ControllerAdvice
public class ResourceExeceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExeception.class)
	public ResponseEntity<StandardError>erro(ObjectNotFoundExeception e,HttpServletRequest request ){
		
StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
}
	
}