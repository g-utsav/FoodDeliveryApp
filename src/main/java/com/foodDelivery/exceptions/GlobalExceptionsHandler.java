package com.foodDelivery.exceptions;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionsHandler {

  @ExceptionHandler (AdminAcessNotGrantedException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(AdminAcessNotGrantedException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.FORBIDDEN);
  }
	
  @ExceptionHandler (BillException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(BillException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler (CartException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CartException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
	
  @ExceptionHandler (CategoryException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CategoryException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler (CategoryNotFound.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CategoryNotFound customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (CustomerException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler (CustomerNotFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerNotFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
	
  @ExceptionHandler (InvalidUserNameOrPassword.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(InvalidUserNameOrPassword customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.FORBIDDEN);
  }
  
  @ExceptionHandler (ItemAlreadyPresentException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(ItemAlreadyPresentException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.CONFLICT);
  }
  
  @ExceptionHandler (ItemException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(ItemException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
	
  @ExceptionHandler (ItemNotFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(ItemNotFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (MultipleItemFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(MultipleItemFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.MULTIPLE_CHOICES);
  }
  
  @ExceptionHandler (MultipleRestaurantFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(MultipleRestaurantFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.MULTIPLE_CHOICES);
  }
  
  @ExceptionHandler (NoRestaurantFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(NoRestaurantFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (OrderCompletedException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(OrderCompletedException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.ALREADY_REPORTED);
  }
  
  @ExceptionHandler (OrderDetailsException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(OrderDetailsException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (OrderNotFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(OrderNotFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (RestaurantException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(RestaurantException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler (UnAuthorizedCustomerException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(UnAuthorizedCustomerException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler (UserAccessNotGrantedException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(UserAccessNotGrantedException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.UNAUTHORIZED);
  }
  
  @ExceptionHandler (UserAllReadyLoggedInException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(UserAllReadyLoggedInException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.ALREADY_REPORTED);
  }
  
  @ExceptionHandler (UserNotLoggedInException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(UserNotLoggedInException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
  }
  @ExceptionHandler (CartItemNotFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CartItemNotFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler (CartItemQuantityException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CartItemQuantityException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.FORBIDDEN);
  }
  
  
  @ExceptionHandler (CartNotFoundException.class)
  public ResponseEntity<MyErrorDetails> customerExceptionHandler(CartNotFoundException customerException, WebRequest webRequest){
      MyErrorDetails myErrorDetails = new MyErrorDetails();
      myErrorDetails.setLocalDateTime(LocalDateTime.now());
      myErrorDetails.setMessage(customerException.getMessage());
      myErrorDetails.setDescription(webRequest.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
  }
	
	
	
	
//    @ExceptionHandler (CustomerException.class)
//    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest){
//        MyErrorDetails myErrorDetails = new MyErrorDetails();
//        myErrorDetails.setLocalDateTime(LocalDateTime.now());
//        myErrorDetails.setMessage(customerException.getMessage());
//        myErrorDetails.setDescription(webRequest.getDescription(false));
//        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
//    }
//    
//    @ExceptionHandler (RestaurantException.class)
//    public ResponseEntity<MyErrorDetails> restaurantExceptionHandler(RestaurantException restaurantException, WebRequest webRequest){
//        MyErrorDetails myErrorDetails = new MyErrorDetails();
//        myErrorDetails.setLocalDateTime(LocalDateTime.now());
//        myErrorDetails.setMessage(restaurantException.getMessage());
//        myErrorDetails.setDescription(webRequest.getDescription(false));
//        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
//    }
//    
//    @ExceptionHandler (NoRestaurantFoundException.class)
//    public ResponseEntity<MyErrorDetails> restaurantExceptionHandler(NoRestaurantFoundException noRestaurantFoundException, WebRequest webRequest){
//        MyErrorDetails myErrorDetails = new MyErrorDetails();
//        myErrorDetails.setLocalDateTime(LocalDateTime.now());
//        myErrorDetails.setMessage(noRestaurantFoundException.getMessage());
//        myErrorDetails.setDescription(webRequest.getDescription(false));
//        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
//    }
//    
//    @ExceptionHandler (MultipleRestaurantFoundException.class)
//    public ResponseEntity<MyErrorDetails> restaurantExceptionHandler(MultipleRestaurantFoundException multipleRestaurantFoundException, WebRequest webRequest){
//        MyErrorDetails myErrorDetails = new MyErrorDetails();
//        myErrorDetails.setLocalDateTime(LocalDateTime.now());
//        myErrorDetails.setMessage(multipleRestaurantFoundException.getMessage());
//        myErrorDetails.setDescription(webRequest.getDescription(false));
//        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.MULTIPLE_CHOICES);
//    }
}
