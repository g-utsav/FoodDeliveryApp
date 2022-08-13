package com.foodDelivery.serviceLayer.OrderDetails;

import java.time.LocalDateTime;
import java.util.List;
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
	OrderDetailsDao orderDetailsDao;
	
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
		orderDetailsDao.save(order);
		return order;
	}
	@Override
	public OrderDetails removeOrderDetails(OrderDetails order) {
		Optional<OrderDetails> od1=orderDetailsDao.findById(order.getOrderId());
		
		if(od1.isPresent()) {
			orderDetailsDao.delete(order);
			return order;
		}else {
			throw new OrderDetailsException("Order is not present...");
		}
		
	
	}
	@Override
	public List<OrderDetails> viewOrder() {
		List<OrderDetails> list=orderDetailsDao.findAll();
		return list;
	}
	@Override
	public List<OrderDetails> viewAllOrderByCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
