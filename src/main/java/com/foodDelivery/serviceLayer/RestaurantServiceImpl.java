package com.foodDelivery.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.RestaurantDao;
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.exceptions.MultipleRestaurantFoundException;
import com.foodDelivery.exceptions.NoRestaurantFoundException;
import com.foodDelivery.exceptions.RestaurantException;

@Service
public class RestaurantServiceImpl implements ResturantService{
	
	@Autowired
	RestaurantDao rServ;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		
		List<Restaurant> rList = rServ.findByRestaurantNameAndContactNumber(restaurant.getRestaurantName(), restaurant.getContactNumber());
//		System.out.println(rList);
		
		if(rList.size() == 0) {
			rServ.save(restaurant);
			return restaurant;
		}else {
			throw new RestaurantException("Resturant all ready Exist");
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException,NoRestaurantFoundException,MultipleRestaurantFoundException {
		boolean flag = true;
		if(restaurant.getResturantId() == null) {
			flag = false;
		}
		if(flag) {
			Optional<Restaurant> opt = rServ.findById(restaurant.getResturantId());
			
			if(opt.isPresent()) {
				rServ.save(restaurant);
				return restaurant;
			}else {
				throw new NoRestaurantFoundException("No Restaurant was Found, Try Addind/Creating a Restaurant First");
			}
		}else {
			List<Restaurant> rList = rServ.findByRestaurantNameAndContactNumber(restaurant.getRestaurantName(), restaurant.getContactNumber());
			System.out.println(rList);
			if(rList.size() == 0 ) {
				throw new NoRestaurantFoundException("No Restaurant was Found, Try Addind/Creating a Restaurant First");
			}else if(rList.size()>1) {
				throw new MultipleRestaurantFoundException("Multiple Restaurant Found. Pass the Restaurant ID");
			}else {
				restaurant.setResturantId(rList.get(0).getResturantId());
				return rServ.save(restaurant);
			}
		}
	}

	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws NoRestaurantFoundException {
		
		Optional<Restaurant> opt = rServ.findById(restaurantId);
		
		if(opt.isPresent()) {
			rServ.delete(opt.get());
			return opt.get();
		}else {
			throw new NoRestaurantFoundException("No Restaurant was Found, Try Addind/Creating a Restaurant First");
		}
		
	}

	@Override
	public Restaurant getResturant(Integer restaurantId) throws NoRestaurantFoundException {
		Optional<Restaurant> opt = rServ.findById(restaurantId);
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new NoRestaurantFoundException("No Restaurant was Found, Try Addind/Creating a Restaurant First");
		}
		
	}

	@Override
	public List<Restaurant> viewRestaurantByName(String restaurantName) throws NoRestaurantFoundException {
		List<Restaurant> rList = rServ.findByRestaurantName(restaurantName);
		
		if(rList.size() != 0) {
			return rList;
		}else {
			throw new NoRestaurantFoundException("No Restaurant was Found by the give Name, Try Addind/Creating a Restaurant First");
		}
	}
	


}
