package com.foodDelivery.dataAcessLayer;

import com.foodDelivery.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

    @Query ("from Address a where a.area=?1 and a.buildingName=?2 and a.city=?3 and a.country=?4 and a.pincode=?5 and a.state=?6 and a.streetNo=?7")
    public Address findByAddress (String area, String buildingName, String city, String country, Integer pincode, String state, String strretNo);
}
