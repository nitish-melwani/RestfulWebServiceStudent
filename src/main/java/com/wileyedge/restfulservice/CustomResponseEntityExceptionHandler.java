package com.wileyedge.restfulservice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice //Catch Exceptions
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleAllExceptions(Exception ex, WebRequest req) {
		System.out.println("Inside handleAllExceptions");
		ExceptionResponse expResp = new ExceptionResponse(new Date(),ex.getMessage(),"Detail Description of the Exception");
		return expResp;
//		return new ResponseEntity(expResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public final ExceptionResponse handleUserNotFoundExceptions(StudentNotFoundException ex, WebRequest req) {
		System.out.println("Inside handleUserNotFoundExceptions");
		ExceptionResponse expResp = new ExceptionResponse(new Date(),ex.getMessage(),"The requested User ID is not present in the repository");
		return expResp;
//		return new ResponseEntity(expResp,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Inside handleMethodArgumentNotValid");
		ExceptionResponse expresponse = new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().toString());
		return new ResponseEntity(expresponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
