package com.foodDelivery.exceptions;

import com.foodDelivery.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler (CustomerException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(customerException.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
