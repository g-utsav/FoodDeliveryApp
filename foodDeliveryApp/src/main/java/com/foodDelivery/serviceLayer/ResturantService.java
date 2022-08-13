package com.foodDelivery.serviceLayer;

import java.lang.module.ResolutionException;

import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.RestaurantException;

public interface ResturantService {

	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
	
	public Restaurant getResturant(Integer restaurantId)throws RestaurantException;
	
}
