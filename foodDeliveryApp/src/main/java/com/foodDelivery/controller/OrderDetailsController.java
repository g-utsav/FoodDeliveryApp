package com.foodDelivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.foodDelivery.serviceLayer.OrderDetails.OrderDetailsService;
import com.foodDelivery.serviceLayer.admin.AdminService;

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
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.entity.dto.OrderDetailsDto;
import com.foodDelivery.entity.dto.RestaurantDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.OrderCompletedException;
import com.foodDelivery.exceptions.OrderDetailsException;
import com.foodDelivery.exceptions.OrderNotFoundException;
import com.foodDelivery.exceptions.RestaurantException;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private AdminService adminServ;
	
	
	
	@PostMapping("/AddOrder")


	public ResponseEntity<OrderDetails> AddOrderDetails(@Valid @RequestBody Customer customer) throws CustomerNotFoundException{

		return new ResponseEntity<OrderDetails>(orderDetailsService.AddOrder(customer),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeOrder/{orderid}")
	public ResponseEntity<OrderDetails> RemoveOrder(@Valid @PathVariable("orderid") Integer orderid)throws OrderCompletedException,OrderDetailsException {
		return new ResponseEntity<>(orderDetailsService.removeOrderDetails(orderid),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allPendingOrders/{custid}")
	public ResponseEntity<List<OrderDetails>> viewPendingOrderHandler(@Valid @PathVariable("custid")Integer custId)throws OrderNotFoundException{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewPendingOrder(custId),HttpStatus.FOUND);
	}
	
	@GetMapping("/allOrdersByCustomer/{custid}")
	public ResponseEntity<List<OrderDetails>> allOrdersByCustomer(@Valid @PathVariable("custid")Integer custId)throws CustomerNotFoundException, OrderNotFoundException{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewAllOrderByCustomer(custId),HttpStatus.FOUND);
	}
	

//	@PutMapping("/updateOrder")
//	public ResponseEntity<OrderDetails> updateOrder(@Valid @RequestBody OrderDetails order)throws OrderNotFoundException{
//		return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(order),HttpStatus.ACCEPTED);
//	}
//	
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails>updateOrderDeatilsHandler(@Valid @RequestBody OrderDetailsDto orderdetailsDto) throws AdminAcessNotGrantedException,OrderNotFoundException{

			if(!adminServ.verifyAdmin(orderdetailsDto.getCustomerToken(), orderdetailsDto.getOrderdetails().getOrderId())) ;
			return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(orderdetailsDto.getOrderdetails()), HttpStatus.ACCEPTED);
	}
	
}
