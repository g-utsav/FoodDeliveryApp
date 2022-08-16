package com.foodDelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.UnAuthorizedCustomerException;
import com.foodDelivery.exceptions.UserAllReadyLoggedInException;
import com.foodDelivery.serviceLayer.Customer.CustomerServiceImpl;

//import com.masai.UserLogin.Module.Customer;
//import com.masai.UserLogin.Service.CustomerServiceImpl;
//import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
//import com.masai.UserLogin.exception.UserAllReadyLoggedInException;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	//to Register user
	
	@PostMapping(value = "/")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) throws UserAllReadyLoggedInException {
		
		return customerServiceImpl.createCustomer(customer);
	}
	
	//to update existing
	
	@PutMapping(value = "/")
	public Customer UpdateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException {
		
		return customerServiceImpl.updateCustomer(customer,key);                                                   
	}
	

}

