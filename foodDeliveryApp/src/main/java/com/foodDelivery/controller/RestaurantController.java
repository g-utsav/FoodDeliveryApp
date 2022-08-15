package com.foodDelivery.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.MultipleRestaurantFoundException;
import com.foodDelivery.exceptions.NoRestaurantFoundException;
import com.foodDelivery.exceptions.RestaurantException;
import com.foodDelivery.serviceLayer.ResturantService;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {

	@Autowired
	ResturantService rServ;
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> addRestaurantHandler(@Valid @RequestBody Restaurant restaurant) throws RestaurantException{
		return new ResponseEntity<>(rServ.addRestaurant(restaurant), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{token}")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@Valid @RequestBody Restaurant restaurant, @PathVariable("token") String token) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException {
		
		return new ResponseEntity<>(rServ.updateRestaurant(restaurant), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{rId}")
	public  ResponseEntity<Restaurant> removeRestaurantHandler(@PathVariable("rId") Integer restaurantId) throws NoRestaurantFoundException {
		return new ResponseEntity<>(rServ.removeRestaurant(restaurantId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{rId}")
	public ResponseEntity<Restaurant> getResturantHandler(@PathVariable("rId") Integer restaurantId) throws NoRestaurantFoundException {
		return new ResponseEntity<>(rServ.getResturant(restaurantId), HttpStatus.FOUND);
	}
	
	@GetMapping("/findByName/{rN}")
	public ResponseEntity<List<Restaurant>> viewRestaurantByNameHandler(@PathVariable("rN") String restaurantName) throws NoRestaurantFoundException {
		return new ResponseEntity<>(rServ.viewRestaurantByName(restaurantName), HttpStatus.FOUND);
	}
	
}
