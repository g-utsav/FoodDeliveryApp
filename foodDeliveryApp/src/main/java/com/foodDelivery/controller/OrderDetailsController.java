package com.foodDelivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.foodDelivery.serviceLayer.OrderDetails.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.OrderDetails;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.OrderCompletedException;
import com.foodDelivery.exceptions.OrderDetailsException;
import com.foodDelivery.exceptions.OrderNotFoundException;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/AddOrder")
	public ResponseEntity<OrderDetails> AddOrderDetails(@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<OrderDetails>(orderDetailsService.AddOrder(customer),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeOrder/{orderid}")
	public ResponseEntity<OrderDetails> RemoveOrder(@Valid @PathVariable("orderid") Integer orderid)throws OrderCompletedException,OrderDetailsException {
		return new ResponseEntity<>(orderDetailsService.removeOrderDetails(orderid),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allOrders/{custid}")
	public ResponseEntity<List<OrderDetails>> getAllorders(@Valid @PathVariable("custid")Integer custId)throws OrderNotFoundException{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewPendingOrder(custId),HttpStatus.FOUND);
	}
	
	@GetMapping("/allOrdersByCustomer/{custid}")
	public ResponseEntity<List<OrderDetails>> allOrdersByCustomer(@Valid @PathVariable("custid")Integer custId)throws CustomerNotFoundException, OrderNotFoundException{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewAllOrderByCustomer(custId),HttpStatus.FOUND);
	}
	

	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrder(@Valid @RequestBody OrderDetails order)throws OrderNotFoundException{
		return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(order),HttpStatus.ACCEPTED);
	}
	
}
