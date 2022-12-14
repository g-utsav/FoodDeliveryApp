package com.foodDelivery.serviceLayer;

import java.util.List;
import java.util.Set;

import com.foodDelivery.entity.Item;
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.MultipleRestaurantFoundException;
import com.foodDelivery.exceptions.NoRestaurantFoundException;
import com.foodDelivery.exceptions.RestaurantException;

public interface ResturantService {

	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws NoRestaurantFoundException;
	
	public Restaurant getResturant(Integer restaurantId)throws NoRestaurantFoundException;
	
	public List<Restaurant> viewRestaurantByName(String restaurantName)throws NoRestaurantFoundException;
	
	public Restaurant addItemInRestaurant(Integer restId, Integer itemId) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException;
	
	public Set<Item> viewAllItemsFromRestaurant(Integer restId) throws NoRestaurantFoundException;
	
}
