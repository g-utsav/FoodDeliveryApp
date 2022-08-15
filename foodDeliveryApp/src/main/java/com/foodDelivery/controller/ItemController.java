package com.foodDelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodDelivery.entity.Category;
import com.foodDelivery.entity.Item;
import com.foodDelivery.exceptions.CategoryException;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;
import com.foodDelivery.serviceLayer.Item.ItemService;

public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/")
	public ResponseEntity<Item>  addItemHandler(@Valid @RequestBody Item item) throws ItemAlreadyPresentException{
		
		return  new ResponseEntity <> (itemService.addItem(item),HttpStatus.CREATED);
	}
	
	@PutMapping("/{itemId}")
	public ResponseEntity<Item> updateItemHandler (@Valid @RequestBody Item item, @PathVariable ("itemId") Integer itemId) throws ItemNotFoundException, MultipleItemFoundException {
		
		return new ResponseEntity<>(itemService.updateItem(item),HttpStatus.ACCEPTED); 
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<Item> viewItemHandler (@Valid @PathVariable("itemId") Integer itemId) throws ItemNotFoundException{
		return new ResponseEntity<> (itemService.viewItem(itemId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{itemId}")
	public ResponseEntity<Item> removeItemHandler(@Valid @PathVariable("itemId") Integer itemId) throws ItemNotFoundException{
		return new ResponseEntity<> (itemService.removeItem(itemId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{itemName}")
	public ResponseEntity<List<Item>> viewAllItemsByItemnameHandler(@Valid @PathVariable("itemName") String itemName) throws ItemNotFoundException{
		return new ResponseEntity<List<Item>> (itemService.viewAllItemsByItemname(itemName),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{categoryName}")
	public ResponseEntity<List<Item>> viewAllItemsByCategoryHandler (@Valid @PathVariable("categoryName")String categoryName) throws CategoryNotFound{
		return new ResponseEntity<List<Item>> (itemService.viewAllItemsByCategory(categoryName),HttpStatus.ACCEPTED);
	}
	
}
