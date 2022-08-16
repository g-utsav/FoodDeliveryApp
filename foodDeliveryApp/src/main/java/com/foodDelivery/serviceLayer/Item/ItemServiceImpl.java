package com.foodDelivery.serviceLayer.Item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.ItemDao;
import com.foodDelivery.entity.Item;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao iDao;
	
	@Override
	public Item addItem(Item item) throws ItemAlreadyPresentException{
		iDao.save(item);
		return item;
	}

	@Override
	public Item  updateItem (Item item) throws ItemNotFoundException, MultipleItemFoundException {
		// TODO Auto-generated method stub
		boolean flag =true;
		if(item.getItemId()==null) {
			flag = false;
		}
		if(flag) {
			Optional<Item> opt = iDao.findById(item.getItemId());
			
			if(opt.isPresent()) {
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
				return iDao.save(opt.get(0));
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
		// TODO Auto-generated method stub
		Optional<Item> opt = iDao.findById(itemId);
		
		if(opt.isPresent()) {
			 iDao.delete(opt.get());
			 return opt.get();
		}else {
			throw new ItemNotFoundException("Item not found by the given ID");
		}

	}

	@Override
	public List<Item> viewAllItemsByItemName(String itemName) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		List <Item> item  = iDao.findByItemName(itemName);
		if (item.size()==0) {
			throw new ItemNotFoundException("Item not found by the given name");
		}else {
			return item;
		}

	}

	@Override
	
	public List<Item> viewAllItemsByCategory(String categoryName) throws CategoryNotFound {

		List<Item> item = iDao.findItemByCategoryName(categoryName);
		
		if (item.size()==0) {
			throw new CategoryNotFound("Item not found by the given name");
		}else {
			return item;
		}
	}

}
