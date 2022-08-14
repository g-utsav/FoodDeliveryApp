package com.masai.UserLogin.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.Service.CustomerServiceImpl;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	//to Register user
	
	@PostMapping(value = "/customer")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) throws UserAllReadyLoggedInException {
		
		return customerServiceImpl.createCustomer(customer);
	}
	
	//to update existing
	
	@PutMapping(value = "/customer")
	public Customer UpdateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException {
		
		return customerServiceImpl.updateCustomer(customer,key);                                                   
	}
	

}
