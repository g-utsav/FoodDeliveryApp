package com.foodDelivery.serviceLayer;

import java.lang.module.ResolutionException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.RestaurantDao;
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.RestaurantException;

@Service
public class RestaurantServiceImpl implements ResturantService{
	
	@Autowired
	RestaurantDao rServ;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		
//		Optional<Restaurant> opt = rServ.findOne(Example<Restaurant>);
		
		if(true) {
			rServ.save(restaurant);
			return restaurant;
		}else {
			throw new RestaurantException("Resturant all ready Exist");
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getResturant(Integer restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
