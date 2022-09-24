package com.foodDelivery.serviceLayer.OrderDetails;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.OrderDetails;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.OrderCompletedException;
import com.foodDelivery.exceptions.OrderDetailsException;
import com.foodDelivery.exceptions.OrderNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {

	public OrderDetails AddOrder(Customer customer) throws CustomerNotFoundException;
	
	public OrderDetails removeOrderDetails (Integer orderId) throws OrderCompletedException,OrderDetailsException;
  
	public List<OrderDetails> viewPendingOrder (Integer custid)throws OrderNotFoundException;
	
	public List <OrderDetails> viewAllOrderByCustomer (Integer custid)throws OrderNotFoundException;

	public OrderDetails updateOrder (OrderDetails order)throws OrderNotFoundException;
	
	//public List <OrderDetails> viewAllOrderByResturant (Resturant rest) ;
	
}
