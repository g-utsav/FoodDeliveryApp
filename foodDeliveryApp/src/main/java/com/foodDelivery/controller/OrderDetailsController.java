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
import com.foodDelivery.entity.dto.CustomerDTO;
import com.foodDelivery.entity.dto.CustomerDTOForHttpRequest;
import com.foodDelivery.entity.dto.OrderDetailsDto;
import com.foodDelivery.entity.dto.RestaurantDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.CustomerNotFoundException;
import com.foodDelivery.exceptions.OrderCompletedException;
import com.foodDelivery.exceptions.OrderDetailsException;
import com.foodDelivery.exceptions.OrderNotFoundException;
import com.foodDelivery.exceptions.RestaurantException;
import com.foodDelivery.exceptions.UserAccessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.exceptions.UserNotLoggedInException;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private AdminService adminServ;
	
	
	

	@PostMapping("/")
	public ResponseEntity<OrderDetails> AddOrderDetailsHandler(@Valid @RequestBody CustomerDTOForHttpRequest cDtoHttp) throws UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException, CustomerNotFoundException {
		if(adminServ.verifyUser(cDtoHttp.getcToken())) ;
		return new ResponseEntity<OrderDetails> (orderDetailsService.AddOrder(cDtoHttp.getCustomer()),HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/")
	public ResponseEntity<OrderDetails> removeOrderDetailsHandler(@Valid @RequestBody OrderDetailsDto orderdetailsDto)throws OrderCompletedException,OrderDetailsException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException {
		if(adminServ.verifyUser(orderdetailsDto.getCustomerToken())) ;
		return new ResponseEntity<>(orderDetailsService.removeOrderDetails(orderdetailsDto.getOrderdetails().getOrderId()),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allPendingOrders")
	public ResponseEntity<List<OrderDetails>> viewPendingOrderHandler(@Valid @RequestBody OrderDetailsDto orderdetailsDto)throws OrderNotFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException{
		if(adminServ.verifyUser(orderdetailsDto.getCustomerToken())) ;
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewPendingOrder(orderdetailsDto.getCustomerToken().getCustId()),HttpStatus.FOUND);
	}
	
	@GetMapping("/allOrdersByCustomer")
	public ResponseEntity<List<OrderDetails>> allOrdersByCustomer(@Valid @RequestBody OrderDetailsDto orderdetailsDto)throws CustomerNotFoundException, OrderNotFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException{
		if(adminServ.verifyUser(orderdetailsDto.getCustomerToken())) ;
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.viewAllOrderByCustomer(orderdetailsDto.getCustomerToken().getCustId()),HttpStatus.FOUND);
	}
	
	@PutMapping("/")
	public ResponseEntity<OrderDetails>updateOrderDeatilsHandler(@Valid @RequestBody OrderDetailsDto orderdetailsDto) throws AdminAcessNotGrantedException,OrderNotFoundException{

			if(!adminServ.verifyAdmin(orderdetailsDto.getCustomerToken(), orderdetailsDto.getCustomerToken().getCustId())) ;
			return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(orderdetailsDto.getOrderdetails()), HttpStatus.ACCEPTED);
	}
	@PutMapping("/changestatus")
	public ResponseEntity<OrderDetails>changeOrderStatusHandler(@Valid @RequestBody OrderDetailsDto orderdetailsDto) throws AdminAcessNotGrantedException,OrderNotFoundException{
		
		if(!adminServ.verifyAdmin(orderdetailsDto.getCustomerToken(), orderdetailsDto.getCustomerToken().getCustId())) ;
		return new ResponseEntity<OrderDetails>(orderDetailsService.ChangeStatus(orderdetailsDto.getOrderdetails().getOrderId()), HttpStatus.ACCEPTED);
	}
	
}
