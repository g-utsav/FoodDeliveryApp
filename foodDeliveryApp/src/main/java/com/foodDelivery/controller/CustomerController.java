package com.foodDelivery.controller;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.serviceLayer.Cart.CartService;
import com.foodDelivery.serviceLayer.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @GetMapping (value = "/view/{id}")
    public ResponseEntity<Customer> getCustomerHandler(@PathVariable ("id") Integer id){
        return new ResponseEntity<>(customerService.viewCustomer(id),HttpStatus.FOUND);
    }

    @PostMapping (value = "/add")
    public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer){

        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/update/{id}")
    public ResponseEntity<Customer> updateCustomerHandler(@PathVariable ("id") Integer id, @RequestBody Customer customer){

        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.ACCEPTED);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<Customer> deleteCustomerhandler(@PathVariable ("id") Integer id){

        return new ResponseEntity<>(customerService.removeCustomer(id),HttpStatus.OK);
    }
}
