package com.masai.UserLogin.Util;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.UserLogin.Module.CurrentUserSession;
import com.masai.UserLogin.Module.Customer;
import com.masai.UserLogin.Module.CustomerDTO;
import com.masai.UserLogin.Repository.CustomerDAO;
import com.masai.UserLogin.Repository.SessionDAO;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;
import com.masai.UserLogin.exception.UserNotFound;

import net.bytebuddy.utility.RandomString;


@Service
public class CustomerLogInImpl implements CustomerLogIn{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
	
	@Override
   public String logIntoAccount(CustomerDTO customerDTO) throws UserNotFound, UserAllReadyLoggedInException {
		
    Optional<Customer> opt = customerDAO.findByMobileNoAndPassword(customerDTO.getMobileNo(),customerDTO.getPassword());

		if(!opt.isPresent()) {
			
			System.out.println("Please Enter valid Mobile Number ");
			
			throw new UserNotFound("User Not Found first signUp");
		}
		
		Customer newCustomer1 = opt.get();
		Integer customerId1 = newCustomer1.getCustomrId();
		
		Optional<CurrentUserSession> CurrentUserOptional1 = sessionDAO.findByCustomerId(customerId1);
		
		if(CurrentUserOptional1.isPresent()) {
			
			throw new UserAllReadyLoggedInException("User allready logged in with this Mobile Number ");
		}
		
		
		
		
		if(newCustomer1.getPassword().equals(customerDTO.getPassword())) {
			
			String key = RandomString.make(6);
		
		CurrentUserSession currentUserSession = new CurrentUserSession(newCustomer1.getCustomrId(),key,LocalDateTime.now());
		
		sessionDAO.save(currentUserSession);
		
		return currentUserSession.toString();
		
		}
		else {
			
			return "Please Enter valid Password";
		}
		
   
		
	}
	
	@Override
	public String logOutFromAccount(String key) throws UnAuthorizedCustomerException {
		
		Optional<CurrentUserSession> CurrentUserOptional = sessionDAO.findByUuid(key);
		
		if(!CurrentUserOptional.isPresent()) {
			
			System.out.println("User is not logged i with this Number");
			throw new UnAuthorizedCustomerException("User is not logged i with this Number");
		}
		
		CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
		sessionDAO.delete(currentUserSession);
		return "Logged Out...";
	}



		
	

}
