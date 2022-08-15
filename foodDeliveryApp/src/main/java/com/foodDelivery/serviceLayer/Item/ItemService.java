package com.foodDelivery.serviceLayer.Item;

import java.util.List;

import com.foodDelivery.entity.Item;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;

public interface ItemService {
	
	public Item addItem (Item item) throws ItemAlreadyPresentException; 
	
	public Item updateItem (Item item) throws ItemNotFoundException,MultipleItemFoundException;
	
	public Item viewItem (Integer itemId) throws ItemNotFoundException ;
	
	public Item removeItem (Integer itemId) throws ItemNotFoundException ;
	
	public List < Item > viewAllItemsByCategory (String categoryName) throws CategoryNotFound ;
	
//	List < Item > viewAllItemsByResturant (String resturantName);
	
	public List < Item > viewAllItemsByItemname (String itemName) throws ItemNotFoundException ;

}
