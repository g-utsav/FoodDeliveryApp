package com.foodDelivery.serviceLayer.Customer;

import com.foodDelivery.dataAcessLayer.AddressDao;
import com.foodDelivery.dataAcessLayer.CustomerDao;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CustomerDao customerDao;


    @Override
    public Customer addCustomer(Customer customer) throws CustomerException{

        Customer c1 = customerDao.findCustomer(customer.getFirstName(),customer.getLastName(),customer.getMobileNumber(),customer.getEmail());

        if (c1==null){
            return customerDao.save(customer);
        }
        else{
            throw new CustomerException("Customer Already Exists...");
        }
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) throws CustomerException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            return customerDao.save(customer);
        }
        else {
            throw new CustomerException("Customer Not Exists...");
        }
    }

    @Override
    public Customer removeCustomer(Integer id) throws CustomerException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            Customer customer = (Customer) opt.get();

            customerDao.delete(customer);
            return customer;
        }
        else {
            throw new CustomerException("Customer Not Exists...");
        }
    }

    @Override
    public Customer viewCustomer(Integer id) throws CustomerException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            return  (Customer) opt.get();
        }
        else {
            throw new CustomerException("Customer Not Exists...");
        }
    }

}
