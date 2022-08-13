package com.foodDelivery.serviceLayer.OrderDetails;

import java.time.LocalDateTime;
import java.util.Optional;

import com.foodDelivery.dataAcessLayer.CustomerDao;
import com.foodDelivery.exceptions.OrderDetailsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodDelivery.dataAcessLayer.OrderDetailsDao;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.OrderDetails;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsDao orderServ;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public OrderDetails AddOrder(Integer id) {
		OrderDetails order =new OrderDetails();
		order.setOrderDateTime(LocalDateTime.now());
		order.setOrderStatus("Completed");
		Optional opt =customerDao.findById(id);
		if(opt.isPresent()) {
			order.setCustomer((Customer) opt.get());
		}
		orderServ.save(order);
		return order;
	}
	@Override
	public OrderDetails removeOrderDetails(OrderDetails order) {
		Optional<OrderDetails> od1=orderServ.findById(order.getOrderId());
		
		if(od1.isPresent()) {
			orderServ.delete(order);
			return order;
		}else {
			throw new OrderDetailsException("Order is not present...");
		}
		
	
	}

	

}
