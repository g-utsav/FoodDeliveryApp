package com.foodDelivery.serviceLayer.OrderDetails;

import com.foodDelivery.entity.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {

	public OrderDetails AddOrder(Integer id);
	
	public OrderDetails removeOrderDetails (OrderDetails order);
}
