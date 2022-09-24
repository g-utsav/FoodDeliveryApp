package com.foodDelivery.controller;

import com.foodDelivery.entity.Address;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.serviceLayer.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping (value = "/add")
    public ResponseEntity<Address> addAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/update")
    public ResponseEntity<Address> updateAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.ACCEPTED);
    }

    @DeleteMapping (value = "/remove")
    public ResponseEntity<Address> removeAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.removeAddress(address),HttpStatus.OK);
    }

    @GetMapping (value = "/get")
    public ResponseEntity<Address> viewAddressHnadler(@RequestBody Customer customer){
        return new ResponseEntity<>(addressService.viewAddress(customer.getAddress()),HttpStatus.FOUND);
    }

}
