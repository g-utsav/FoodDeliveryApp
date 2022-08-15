package com.masai.UserLogin.Util;

import com.masai.UserLogin.Module.CurrentUserSession;
import com.masai.UserLogin.Module.CustomerDTO;
import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
import com.masai.UserLogin.exception.UserAllReadyLoggedInException;
import com.masai.UserLogin.exception.UserNotFound;


public interface CustomerLogIn {

	public String logOutFromAccount(String key) throws UnAuthorizedCustomerException;

	public String logIntoAccount(CustomerDTO customerDTO)throws UserNotFound, UserAllReadyLoggedInException;

	
}
