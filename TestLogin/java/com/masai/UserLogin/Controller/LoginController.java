package com.masai.UserLogin.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.UserLogin.Module.CurrentUserSession;
import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.Module.CustomerDTO;
import com.masai.UserLogin.Util.CustomerLogInImpl;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;
import com.masai.UserLogin.exception.UserNotFound;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerLogInImpl customerLogIn;
	
	
	//for user login
	
	@PostMapping(value = "/login")
	public String logInCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws UserNotFound, UserAllReadyLoggedInException {
		
		return customerLogIn.logIntoAccount(customerDTO);
		
	}

	
	//for user logOut
	
	@PatchMapping(value = "/logout")
	public String logOutCustomer(@Valid @RequestParam(required = false) Customer customer, String key) throws UnAuthorizedCustomerException {
			
		return customerLogIn.logOutFromAccount(key);
			
		}

}
