package com.foodDelivery.serviceLayer.Customer;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.CustomerException;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.UnAuthorizedCustomerException;
import com.foodDelivery.exceptions.UserAllReadyLoggedInException;

public interface CustomerService {

    public Customer addCustomer (Customer customer) throws CustomerException;

    public Customer updateCustomer (Integer id, Customer customer) throws CustomerException, CustomerNotFoundException;

    public Customer removeCustomer (Integer id) throws CustomerException, CustomerNotFoundException;

    public Customer viewCustomer (Integer id) throws CustomerException;
    
    public Customer createCustomer(Customer customer) throws UserAllReadyLoggedInException, CustomerException;
    
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException;
	


}
