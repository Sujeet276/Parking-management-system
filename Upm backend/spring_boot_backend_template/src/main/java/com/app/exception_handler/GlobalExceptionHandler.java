package com.app.exception_handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.app.Dto.ApiResponse;
import com.app.custom_exception.ResourceNotFoundException;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFound(ResourceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> globalRunTimeException(RuntimeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
	}
	
	@ExceptionHandler(Forbidden.class)
	public ResponseEntity<?> handleForbiddenException(Forbidden ex) {
        return new ResponseEntity<>("You don't have permission to access this resource.", HttpStatus.FORBIDDEN);
    }

}
