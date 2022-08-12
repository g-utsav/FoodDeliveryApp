package com.foodDelivery.serviceLayer;

import com.foodDelivery.dataAcessLayer.AddressDao;
import com.foodDelivery.entity.Address;

public interface AddressService {

    public Address addAddress (Address address);

    public Address updateAddress (Address address);

    public Address removeAddress (Address address);

    public Address viewAddress (Address address);
}
