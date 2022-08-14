package com.masai.UserLogin.Service;

import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer) throws UserAllReadyLoggedInException;
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException;
	

}
