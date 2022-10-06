package com.foodDelivery.serviceLayer.Item;

import java.util.List;
import java.util.Set;

import com.foodDelivery.entity.Item;
import com.foodDelivery.entity.dto.DisplayItem;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;

public interface ItemService {
	
	public Item addItem (Item item) throws ItemAlreadyPresentException; 
	
	public Item updateItem (Item item) throws ItemNotFoundException,MultipleItemFoundException;
	
	public Item viewItem (Integer itemId) throws ItemNotFoundException ;
	
	public Item removeItem (Integer itemId) throws ItemNotFoundException ;
	
//	public String viewAllItemsByCategory (String categoryName) throws CategoryNotFound ;
	public List<DisplayItem> viewAllItemsByCategory (String categoryName) throws CategoryNotFound ;
		
	public List<DisplayItem> viewAllItemsByItemName (String itemName) throws ItemNotFoundException ;

}
