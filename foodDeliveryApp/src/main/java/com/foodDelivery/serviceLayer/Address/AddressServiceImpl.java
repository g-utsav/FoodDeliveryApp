package com.foodDelivery.serviceLayer.Address;

import com.foodDelivery.dataAcessLayer.AddressDao;
import com.foodDelivery.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressDao addressDao;


    @Override
    public Address addAddress(Address address) {
        addressDao.save(address);
        return address;
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public Address removeAddress(Address address) {
        return null;
    }

    @Override
    public Address viewAddress(Address address) {
        return null;
    }
}
