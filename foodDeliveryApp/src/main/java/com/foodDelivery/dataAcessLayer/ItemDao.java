package com.foodDelivery.dataAcessLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item,Integer> {

	public List<Item> findByItemName(String itemName);
	
	@Query("from Item i where i.category.categoryName=?1")
	public List<Item> findItemByCategoryName(String categoryName); 
//	Item addItem (Item item) Admin
//	Item updateItem (Item Item) Admin
//	Item viewItem (Integer itemId) Admin
//	Item remove Item (Integer itemId) Admin
//	List < Item > viewAllItemsByCategory (String categoryName) User / Admin
//	List < Item > viewAllItemsByResturant (String resturantName) User / Admin
//	List < Item > viewAllItemsByItemname (String itemName) User / Admin
	
	
}
