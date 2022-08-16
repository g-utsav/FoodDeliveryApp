package com.foodDelivery.serviceLayer.Customer;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.CustomerException;
import com.foodDelivery.exceptions.UnAuthorizedCustomerException;
import com.foodDelivery.exceptions.UserAllReadyLoggedInException;

public interface CustomerService {

    public Customer addCustomer (Customer customer) throws CustomerException;

    public Customer updateCustomer (Integer id, Customer customer) throws CustomerException;

    public Customer removeCustomer (Integer id) throws CustomerException;

    public Customer viewCustomer (Integer id) throws CustomerException;
    
    public Customer createCustomer(Customer customer) throws UserAllReadyLoggedInException;
    
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException;
	


}
