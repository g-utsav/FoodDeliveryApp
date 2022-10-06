package com.foodDelivery.serviceLayer.Item;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.ItemDao;
import com.foodDelivery.dataAcessLayer.RestaurantDao;
import com.foodDelivery.entity.Item;
import com.foodDelivery.entity.Restaurant;
import com.foodDelivery.entity.dto.DisplayItem;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao iDao;
	
	@Autowired
	private RestaurantDao rDao;
	
	@Override
	public Item addItem(Item item) throws ItemAlreadyPresentException{
		
		iDao.save(item);
		
		return item;
	}

	@Override
	public Item  updateItem (Item item) throws ItemNotFoundException, MultipleItemFoundException {
		
		boolean flag =true;
		
		if(item.getItemId()==null) {
		
			flag = false;
		}
		
		if(flag) {
			Optional<Item> opt = iDao.findById(item.getItemId());
			
			if(opt.isPresent()) {
				
				item.getCategory().setCategoryId(opt.get().getCategory().getCategoryId());
				iDao.save(item);
				return item;
			
			}else {
				throw new ItemNotFoundException("Item not found by the given id");
			}
		}
		else {
			List <Item> opt  = iDao.findByItemName(item.getItemName());
			
			if (opt.size()==0) {
				
				throw new ItemNotFoundException("Item not found by the given name");
			
			}else if(opt.size()>1) {
				
				throw new MultipleItemFoundException("Item not found by the given name");
			
			}else {
				
				item.getCategory().setCategoryId(opt.get(0).getCategory().getCategoryId());
				item.setItemId(opt.get(0).getItemId());
				
				return iDao.save(item);
			}
		}
	}
	
	@Override
	public Item viewItem (Integer itemId) throws ItemNotFoundException{
		Optional<Item> opt = iDao.findById(itemId);
		
		if(opt.isPresent()) {
			
			return opt.get();
		
		}else {
		
			throw new ItemNotFoundException("Item not  found by the given ID");
		
		}
	}

	@Override
	public Item removeItem(Integer itemId) throws ItemNotFoundException {
		Optional<Item> optItem = iDao.findById(itemId);
		
		
		if(optItem.isPresent()) {
			
			List<Restaurant> restaurants =  rDao.findAll();
			
			for(int i=0; i<restaurants.size();i++) {
				
				Set<Item> itemset = restaurants.get(i).getItemList();
				List<Item> items = new ArrayList<>(itemset);
				
				for(int j=0; j<items.size();j++) {
					if(items.get(j).getItemId()==itemId) {
						items.remove(j); 
					}
				}
				Set<Item> set = new HashSet<>();
		        set.addAll(items);
		        restaurants.get(i).setItemList(set);
				rDao.save(restaurants.get(i));
			}
			 
			return optItem.get();
		}else {
		
			throw new ItemNotFoundException("Item not found by the given ID");
		
		}
	}

	@Override
	public List<DisplayItem> viewAllItemsByItemName(String itemName) throws ItemNotFoundException {
		
		List<Restaurant> rests = rDao.findAll();
		List <DisplayItem> displayItemsList  = new ArrayList<>();
		
		for(int i=0; i<rests.size();i++) {
			
			Set<Item> items = rests.get(i).getItemList();
			
			for(Item item:items) {
				
				if(item.getItemName().equalsIgnoreCase(itemName)) {
					
					DisplayItem di = new DisplayItem();
					
					di.setCategoryName(item.getCategory().getCategoryName());
					di.setItemName(itemName);
					di.setItemCost(item.getCost());
					di.setRestaurantName(rests.get(i).getRestaurantName());
					
					displayItemsList.add(di);
				}
			}
		}
		
		return displayItemsList;
		

/*		List<Item> item  = iDao.findByItemName(itemName);
		
		List <DisplayItem> displayItemsList  = new ArrayList<>();
		
		for(int i=0; i<item.size();i++) {
			System.out.println(item);
			Set<Restaurant> restaurants=item.get(i).getRestaurants();
			
			String category = item.get(i).getCategory().getCategoryName() ;
			
			Double cost = item.get(i).getCost(); 
			
			for(Restaurant restaurant: restaurants ) {
				
				String restName = restaurant.getRestaurantName();
				DisplayItem di = new DisplayItem(itemName, category, cost, restName);
				
				displayItemsList.add(di);
			}
		}
		
		if (item.size()==0) {
			
			throw new ItemNotFoundException("Item not found by the given name");
		
		}else {

			return displayItemsList;
		}*/

	}

	@Override
	
	public List<DisplayItem> viewAllItemsByCategory(String categoryName) throws CategoryNotFound {

		List<Restaurant> rests = rDao.findAll();
		List <DisplayItem> displayItemsList  = new ArrayList<>();
		
		for(int i=0; i<rests.size();i++) {
			
			Set<Item> items = rests.get(i).getItemList();
			
			for(Item item:items) {
				
				if(item.getCategory().getCategoryName().equalsIgnoreCase(categoryName)) {
					
					DisplayItem di = new DisplayItem();
					
					di.setCategoryName(categoryName);
					di.setItemName(item.getItemName());
					di.setItemCost(item.getCost());
					di.setRestaurantName(rests.get(i).getRestaurantName());
					
					displayItemsList.add(di);
				}
			}
		}
		
		return displayItemsList;
		
		/*List <Item> item  = iDao.findItemByCategoryName(categoryName);
		
		List <DisplayItem> displayItemsList  = new ArrayList<>();
		
		for(int i=0; i<item.size();i++) {
			
			String itemName = item.get(i).getItemName();
			
			Set<Restaurant> restaurants=item.get(i).getRestaurants();
			
			String category = item.get(i).getCategory().getCategoryName() ;
			
			Double cost = item.get(i).getCost(); 
			
			for(Restaurant restaurant: restaurants ) {
				
				String restName = restaurant.getRestaurantName();
				DisplayItem di = new DisplayItem(itemName, category, cost, restName);
				
				displayItemsList.add(di);
			}
		}
		
		if (item.size()==0) {
			
			throw new  CategoryNotFound("Item not found by the given name");
		
		}else {

			return displayItemsList;
		}*/


	}
}
