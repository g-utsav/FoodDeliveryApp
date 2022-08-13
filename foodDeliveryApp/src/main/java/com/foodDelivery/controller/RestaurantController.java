package com.foodDelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.RestaurantException;
import com.foodDelivery.serviceLayer.ResturantService;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {

	@Autowired
	ResturantService rServ;
	
	@PostMapping("/")
	public Restaurant addRestaurantHandler(@Valid @RequestBody Restaurant restaurant) throws RestaurantException{
		return rServ.addRestaurant(restaurant);
	}
	
}
