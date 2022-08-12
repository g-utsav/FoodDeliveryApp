package com.foodDelivery.serviceLayer;

import com.foodDelivery.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer (Customer customer);

    public Customer updateCustomer (Customer customer);

    public Customer removeCustomer (Customer customer);

    public Customer viewCustomer (Customer customer);


}
