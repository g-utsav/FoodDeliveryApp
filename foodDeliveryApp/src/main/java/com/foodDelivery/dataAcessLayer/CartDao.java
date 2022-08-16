package com.foodDelivery.dataAcessLayer;

import com.foodDelivery.entity.Cart;
import com.foodDelivery.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

    @Query("from Item where itemId=?1")        //This method belongs to ItemDao
    public Item findItemById(Integer id);       //I have written here for testing purpose
}