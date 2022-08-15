package com.foodDelivery.dataAcessLayer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Address;
import com.foodDelivery.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer>{
	@Query("select b from Bill b where b.billDateTime >=?1 AND b.billDateTime <=?2")
     public List<Bill> getBillsByDate(LocalDateTime startDate, LocalDateTime endDate);
	@Query("select b from Bill b where b.customer.customerId = ?1")
	 public List<Bill> getBillsByCustomer(Integer customerId);
}
