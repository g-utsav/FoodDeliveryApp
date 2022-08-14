package com.masai.UserLogin.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.UserLogin.Module.CurrentUserSession;
import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.Repository.CustomerDAO;
import com.masai.UserLogin.Repository.SessionDAO;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;

@Service
public class GetCurrentLoginUserSessionDetailsImpl {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	
	public CurrentUserSession getCurrentUserSession(String key) throws UnAuthorizedCustomerException {
		
		Optional<CurrentUserSession> optional=sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			System.out.println("UnAuthorized");
			
			throw new UnAuthorizedCustomerException("This User is UnAuthorized");
		}
		
		return optional.get();
	}
	
	public Integer getCurrentUserSessionId(String key) throws UnAuthorizedCustomerException {
		
      Optional<CurrentUserSession> optional=sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			System.out.println("UnAuthorized");
			throw new UnAuthorizedCustomerException("This User is UnAuthorized");
		}
		
		return optional.get().getId();
		
	}
	
	public Customer getCurrentCustomer(String key) throws UnAuthorizedCustomerException {
		
	      Optional<CurrentUserSession> optional=sessionDAO.findByUuid(key);
			
			if(!optional.isPresent()) {
				System.out.println("UnAuthorized");
				throw new UnAuthorizedCustomerException("This User is UnAuthorized");
			}
			
			
			
			
			Integer customerId= optional.get().getCustomerId();
			 
			return  customerDAO.getById(customerId);
			
		}
	
	
	

}
