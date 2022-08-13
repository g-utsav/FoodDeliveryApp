package com.foodDelivery.dataAcessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Restaurant;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{

}
