package com.foodDelivery.serviceLayer;

import com.foodDelivery.dataAcessLayer.AddressDao;
import com.foodDelivery.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private AddressDao addressDao;


    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer removeCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer viewCustomer(Customer customer) {
        return null;
    }
}
