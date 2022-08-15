package com.foodDelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.CurrentUserSession;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.dto.CustomerDTO;
import com.foodDelivery.exceptions.InvalidUserNameOrPassword;
import com.foodDelivery.exceptions.UnAuthorizedCustomerException;
import com.foodDelivery.exceptions.UserAllReadyLoggedInException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.serviceLayer.logIn.CustomerLogInImpl;

//import com.masai.UserLogin.Module.CurrentUserSession;
//import com.masai.UserLogin.Module.Customer;
//import com.masai.UserLogin.Module.CustomerDTO;
//import com.masai.UserLogin.Util.CustomerLogInImpl;
//import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
//import com.masai.UserLogin.exception.UserAllReadyLoggedInException;
//import com.masai.UserLogin.exception.UserNotFound;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerLogInImpl customerLogIn;
	
	
	//for user login
	
	@PostMapping(value = "/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws UserNotFound, UserAllReadyLoggedInException, InvalidUserNameOrPassword {
		
		return new ResponseEntity<CurrentUserSession>(customerLogIn.logIntoAccount(customerDTO),HttpStatus.ACCEPTED);
		
	}

	
	//for user logOut
	
	@PatchMapping(value = "/logout")
	public  ResponseEntity<CurrentUserSession> logOutCustomer(@Valid @RequestParam(required = false) Customer customer, String key) throws UnAuthorizedCustomerException {
			
		return new ResponseEntity<CurrentUserSession>(customerLogIn.logOutFromAccount(key),HttpStatus.ACCEPTED);
			
		}

}
