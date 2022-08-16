package com.foodDelivery.dataAcessLayer;

import com.foodDelivery.entity.Address;
import com.foodDelivery.entity.CurrentUserSession;
import com.foodDelivery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

    @Query ("from Customer c where c.firstName=?1 and c.lastName=?2 and c.mobileNumber=?3 and c.email=?4")
    public Customer findCustomer(String firstName, String lastName,Long mobileNumber, String email);

    public Customer getById(Integer customerId);

    public Optional<Customer> findByMobileNumber(Long mobileNo);

    public Optional<CurrentUserSession> findByCustomerId(Integer customerId1);

    public Optional<Customer> findByMobileNumberAndPassword(Long mobileNo,String password);
}
