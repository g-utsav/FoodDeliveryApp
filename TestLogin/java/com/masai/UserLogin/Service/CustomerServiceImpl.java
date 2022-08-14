package com.masai.UserLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.Repository.CustomerDAO;
import com.masai.UserLogin.Util.GetCurrentLoginUserSessionDetailsImpl;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
	
	
	@Override
	public Customer createCustomer(Customer customer) throws UserAllReadyLoggedInException {
		
		Optional<Customer> opt = customerDAO.findByMobileNo(customer.getMobileNo());
		
		if(opt.isPresent()) {
			System.out.println("User Already Exist");
			
			throw new UserAllReadyLoggedInException("User allready logged in with this Mobile Number ");
		}
		
		return customerDAO.save(customer);
		
	}
	
	@Override
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException {
		
		Customer customer2 = getCurrentLoginUser.getCurrentCustomer(key);
		
		if(customer2==null) {
			System.out.println("No User found.. try Login first");
			
			throw new UserAllReadyLoggedInException("No User found.. try Login first");
		}
		
		 customerDAO.save(customer);
		
		 return customer;
	}
	

}
