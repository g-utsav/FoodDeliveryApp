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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Item;
import com.foodDelivery.entity.dto.CartItemDTO;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.CategoryNotFound;
import com.foodDelivery.exceptions.ItemAlreadyPresentException;
import com.foodDelivery.exceptions.ItemNotFoundException;
import com.foodDelivery.exceptions.MultipleItemFoundException;
import com.foodDelivery.exceptions.UserAccessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.exceptions.UserNotLoggedInException;
import com.foodDelivery.serviceLayer.Item.ItemService;
import com.foodDelivery.serviceLayer.admin.AdminService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private AdminService aServ;
	
	@PostMapping("/")
	public ResponseEntity<Item>  addItemHandler(@Valid @RequestBody CartItemDTO cartItemDTO) throws ItemAlreadyPresentException,AdminAcessNotGrantedException{
		if(aServ.verifyAdmin(cartItemDTO.getCustomerToken(), cartItemDTO.getCustomerToken().getCustId())) ;
		return  new ResponseEntity <> (itemService.addItem(cartItemDTO.getItem()),HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Item> updateItemHandler (@Valid @RequestBody CartItemDTO cartItemDTO) throws ItemNotFoundException, MultipleItemFoundException,AdminAcessNotGrantedException {
		if(aServ.verifyAdmin(cartItemDTO.getCustomerToken(), cartItemDTO.getCustomerToken().getCustId())) ;
		return new ResponseEntity<>(itemService.updateItem(cartItemDTO.getItem()),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<Item> viewItemHandler (@Valid @RequestBody CartItemDTO cartItemDTO, @PathVariable("itemId") Integer itemId) throws ItemNotFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException{
		if(aServ.verifyUser(cartItemDTO.getCustomerToken())) ;
		return new ResponseEntity<> (itemService.viewItem(itemId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{itemId}")
	public ResponseEntity<Item> removeItemHandler(@Valid @RequestBody CartItemDTO cartItemDTO, @PathVariable("itemId") Integer itemId) throws ItemNotFoundException,AdminAcessNotGrantedException{
		if(aServ.verifyAdmin(cartItemDTO.getCustomerToken(), cartItemDTO.getCustomerToken().getCustId())) ;
		return new ResponseEntity<> (itemService.removeItem(itemId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{itemName}")
	public ResponseEntity<List<Item>> viewAllItemsByItemNameHandler(@Valid @RequestBody CartItemDTO cartItemDTO, @PathVariable("itemName") String itemName) throws ItemNotFoundException, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException{
		if(aServ.verifyUser(cartItemDTO.getCustomerToken())) ;
		return new ResponseEntity<List<Item>> (itemService.viewAllItemsByItemName(itemName),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{categoryName}")
	public ResponseEntity<List<Item>> viewAllItemsByCategoryHandler (@Valid @RequestBody CartItemDTO cartItemDTO, @PathVariable("categoryName")String categoryName) throws CategoryNotFound, UserAccessNotGrantedException, UserNotFound, UserNotLoggedInException{
		if(aServ.verifyUser(cartItemDTO.getCustomerToken())) ;
		return new ResponseEntity<List<Item>> (itemService.viewAllItemsByCategory(categoryName),HttpStatus.ACCEPTED);
	}
	
}
