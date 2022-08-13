package com.foodDelivery.dataAcessLayer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.OrderDetails;
@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

	@Query("from OrderDetails od where od.customer.customerId=?1")
	public List<OrderDetails> findOrderByCustomerId(Integer id);
	

}
