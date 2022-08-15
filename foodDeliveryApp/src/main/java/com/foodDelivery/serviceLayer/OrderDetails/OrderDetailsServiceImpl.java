package com.foodDelivery.serviceLayer.OrderDetails;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.foodDelivery.dataAcessLayer.CustomerDao;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.OrderCompletedException;
import com.foodDelivery.exceptions.OrderDetailsException;
import com.foodDelivery.exceptions.OrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodDelivery.dataAcessLayer.OrderDetailsDao;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.OrderDetails;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsDao orderDetailsDao;
	


	@Override
	public OrderDetails AddOrder(Customer customer){
		OrderDetails order =new OrderDetails();
		order.setOrderDateTime(LocalDateTime.now());
		order.setOrderStatus("Pending");
		order.setCustomer(customer);
		return orderDetailsDao.save(order);
	}
	@Override
	public OrderDetails removeOrderDetails(Integer orderId) throws OrderCompletedException,OrderDetailsException {
		Optional<OrderDetails> od1=orderDetailsDao.findById(orderId);
		
		if(od1.isPresent()) {
			System.out.println(od1.get().getOrderStatus().equals("Pending"));
			if(od1.get().getOrderStatus().equals("Pending")) {
			orderDetailsDao.delete(od1.get());
			return od1.get();
			}else {
				throw new OrderCompletedException("Order is already Completed...");
			}
		}else {
			throw new OrderDetailsException("Order is not present...");
		}
		
	
	}
	@Override
	public List<OrderDetails> viewPendingOrder(Integer custId) throws OrderNotFoundException {
		List<OrderDetails> od1=orderDetailsDao.findPendingOrder(custId);
		
		if(od1.size()!=0) {
			List<OrderDetails> orderlist=orderDetailsDao.findAllOrderByCustomerId(custId);
			return orderlist;
		}else {
			throw new OrderNotFoundException("No pending orders..");
		}
		
		
	}
	
	@Override
	public List<OrderDetails> viewAllOrderByCustomer(Integer custid)throws OrderNotFoundException{
	     
		List<OrderDetails> orderlist =orderDetailsDao.findAllOrderByCustomerId(custid);
		if(orderlist.size()!=0) {
		return orderlist;
		
		}else {
	    	  throw new OrderNotFoundException("order not found with given id");
	      }
	}
	@Override
	public OrderDetails updateOrder(OrderDetails order)throws OrderNotFoundException {
		Optional<OrderDetails> opt=orderDetailsDao.findById(order.getOrderId());
		
		
		if(opt.isPresent()) {
			//Optional opt=orderDetailsDao.findById(order.getOrderId());
			order.setOrderDateTime(LocalDateTime.now());
			OrderDetails ord=orderDetailsDao.save(order);
			return ord;
		}else {
			throw new OrderNotFoundException("Order not found..");
		}
		
	
	}
	

	

}
