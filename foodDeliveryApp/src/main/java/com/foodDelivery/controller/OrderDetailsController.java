package com.foodDelivery.controller;

import javax.validation.Valid;

import com.foodDelivery.serviceLayer.OrderDetails.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodDelivery.entity.OrderDetails;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderSer;
	
	@PostMapping("/AddOrder/{id}")
	public OrderDetails AddOrderDetails(@Valid @PathVariable("id") Integer id) {
		return orderSer.AddOrder(id);
	}
	
	@DeleteMapping("/removeOrder")
	public String RemoveOrder(@Valid @RequestBody OrderDetails orderdeatils) {
		return "order is Removed.....";
	}
	
}
