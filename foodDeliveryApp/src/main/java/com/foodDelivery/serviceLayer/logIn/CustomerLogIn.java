package com.foodDelivery.serviceLayer.logIn;

import com.foodDelivery.entity.CurrentUserSession;
import com.foodDelivery.entity.dto.CustomerDTO;
import com.foodDelivery.exceptions.InvalidUserNameOrPassword;
import com.foodDelivery.exceptions.UnAuthorizedCustomerException;
import com.foodDelivery.exceptions.UserAllReadyLoggedInException;
import com.foodDelivery.exceptions.UserNotFound;




public interface CustomerLogIn {

	public CurrentUserSession logOutFromAccount(String key) throws UnAuthorizedCustomerException;

	public CurrentUserSession logIntoAccount(CustomerDTO customerDTO)throws UserNotFound, UserAllReadyLoggedInException,InvalidUserNameOrPassword;

	
}
