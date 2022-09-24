package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.Restaurant;

public class RestaurantDto {

	private Restaurant restaurant;
	private CustomerToken customerToken;
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public CustomerToken getCustomerToken() {
		return customerToken;
	}
	public void setCustomerToken(CustomerToken customerToken) {
		this.customerToken = customerToken;
	}
	@Override
	public String toString() {
		return "RestaurantDto [restaurant=" + restaurant + ", customerToken=" + customerToken + "]";
	}
	public RestaurantDto(Restaurant restaurant, CustomerToken customerToken) {
		super();
		this.restaurant = restaurant;
		this.customerToken = customerToken;
	}
	public RestaurantDto() {
		super();
	}
	
	
	
}
