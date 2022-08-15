package com.foodDelivery.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice

public class GlobalExceptionHandler {
	
	
	//to handle specific UserNotFoundException
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<MyErrorDetails> myIllegalHandler(UserNotFound ie,WebRequest req) {
	
	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
	ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	return re;
	}
	
	
	
	//to handle specific NullValueerrorException
	
	@ExceptionHandler(NullValueerror.class)
	public ResponseEntity<MyErrorDetails> myIllegalHandler(NullValueerror ie,WebRequest req) {
	System.out.println("inside myHandler method...");
	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
	ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	return re;
	}
	
	
	
	//to handle specific InvalidURIException
	
		@ExceptionHandler(InvalidURIException.class)
		public ResponseEntity<MyErrorDetails> myIllegalHandler(InvalidURIException ie,WebRequest req) {
		System.out.println("inside myHandler method...");
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return re;
		}

	
	
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e,WebRequest req) {
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	

}
