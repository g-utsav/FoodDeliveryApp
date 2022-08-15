package com.foodDelivery.dataAcessLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Restaurant;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{

	public List<Restaurant> findByRestaurantNameAndContactNumber(String restaurantName, Integer contactNumber);
	
	public List<Restaurant> findByRestaurantName(String restaurantName);
	
}
