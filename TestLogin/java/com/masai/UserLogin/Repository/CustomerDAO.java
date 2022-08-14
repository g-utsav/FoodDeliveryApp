package com.masai.UserLogin.Repository;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.UserLogin.Module.CurrentUserSession;
import com.masai.UserLogin.Module.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	Customer getById(Integer customerId);

	Optional<Customer> findByMobileNo(Integer mobileNo);

	Optional<CurrentUserSession> findByCustomrId(Integer customerId1);
	
	Optional<Customer> findByMobileNoAndPassword(Integer mobileNo,String password);

}
