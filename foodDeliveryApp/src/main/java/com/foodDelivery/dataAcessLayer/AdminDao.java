package com.foodDelivery.dataAcessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Admin;
import com.foodDelivery.entity.Customer;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	@Query("from Admin a where a.customer.customerId=?1")
	public Admin findCustomerIdIfExist(Integer customerId);
	
}
