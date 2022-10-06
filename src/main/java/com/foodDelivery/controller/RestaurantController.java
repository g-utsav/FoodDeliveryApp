package com.foodDelivery.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

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

import com.foodDelivery.entity.Item;
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.entity.dto.RestaurantDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.MultipleRestaurantFoundException;
import com.foodDelivery.exceptions.NoRestaurantFoundException;
import com.foodDelivery.exceptions.RestaurantException;
import com.foodDelivery.exceptions.UserAccessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.exceptions.UserNotLoggedInException;
import com.foodDelivery.serviceLayer.ResturantService;
import com.foodDelivery.serviceLayer.admin.AdminService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private ResturantService rServ;
	
	@Autowired
	private AdminService aServ;
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> addRestaurantHandler(@Valid @RequestBody RestaurantDto restaurantDto) throws RestaurantException,AdminAcessNotGrantedException{
//			System.out.println(restaurantDto.getRestaurant()+" \n"+restaurantDto.getCustomerToken());
			if(!aServ.verifyAdmin(restaurantDto.getCustomerToken(), restaurantDto.getCustomerToken().getCustId()));
			return new ResponseEntity<>(rServ.addRestaurant(restaurantDto.getRestaurant()), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@Valid @RequestBody RestaurantDto restaurantDto) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException, AdminAcessNotGrantedException {
		if(!aServ.verifyAdmin(restaurantDto.getCustomerToken(), restaurantDto.getCustomerToken().getCustId()));
		return new ResponseEntity<>(rServ.updateRestaurant(restaurantDto.getRestaurant()), HttpStatus.ACCEPTED);
	}
	@PutMapping("/item/{rid}/{iid}")
	public ResponseEntity<Restaurant> addItemToRestaurantHandler( @PathVariable("rid") Integer rid, @PathVariable("iid") Integer iid ) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException, AdminAcessNotGrantedException {
//		if(!aServ.verifyAdmin(restaurantDto.getCustomerToken(), restaurantDto.getCustomerToken().getCustId()));
		return new ResponseEntity<>(rServ.addItemInRestaurant(rid,iid), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{rId}")
	public  ResponseEntity<Restaurant> removeRestaurantHandler(@Valid @RequestBody RestaurantDto restaurantDto, @PathVariable("rId") Integer restaurantId) throws NoRestaurantFoundException, AdminAcessNotGrantedException {
		if(!aServ.verifyAdmin(restaurantDto.getCustomerToken(), restaurantDto.getCustomerToken().getCustId()));
		return new ResponseEntity<>(rServ.removeRestaurant(restaurantId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{rId}")
	public ResponseEntity<Restaurant> getResturantHandler(@Valid @RequestBody RestaurantDto restaurantDto, @PathVariable("rId") Integer restaurantId) throws NoRestaurantFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException {
		if(aServ.verifyUser(restaurantDto.getCustomerToken()));
		return new ResponseEntity<>(rServ.getResturant(restaurantId), HttpStatus.FOUND);
	}
	
	@GetMapping("/findByName/{rN}")
	public ResponseEntity<List<Restaurant>> viewRestaurantByNameHandler(@Valid @RequestBody RestaurantDto restaurantDto, @PathVariable("rN") String restaurantName) throws NoRestaurantFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException {
		if(aServ.verifyUser(restaurantDto.getCustomerToken()));
		return new ResponseEntity<>(rServ.viewRestaurantByName(restaurantName), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewallitems/{rid}")
	public ResponseEntity<Set<Item>> viewAllItemsFromRestaurantHandler(@PathVariable("rid") Integer rid) throws NoRestaurantFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException {

		return new ResponseEntity<>(rServ.viewAllItemsFromRestaurant(rid), HttpStatus.FOUND);
	}
	

}
