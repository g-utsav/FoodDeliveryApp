package com.foodDelivery.serviceLayer.OrderDetails;

import com.foodDelivery.entity.OrderDetails;


import java.util.List;


import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {

	public OrderDetails AddOrder(Integer id);
	
	public OrderDetails removeOrderDetails (OrderDetails order);

  
	public List<OrderDetails> viewOrder ();
	
	public List <OrderDetails> viewAllOrderByCustomer (Integer id) ;


}
