package com.foodDelivery.serviceLayer.Customer;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.CustomerException;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer (Customer customer) throws CustomerException;

    public Customer updateCustomer (Integer id, Customer customer) throws CustomerException;

    public Customer removeCustomer (Integer id) throws CustomerException;

    public Customer viewCustomer (Integer id) throws CustomerException;


}
