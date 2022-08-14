package com.foodDelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Category;
import com.foodDelivery.exceptions.CategoryException;
import com.foodDelivery.serviceLayer.Category.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cService;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategoryHandler(@Valid @RequestBody Category category )  throws CategoryException{
		
		return new ResponseEntity<>(cService.addCategory(category),HttpStatus.CREATED);
	}
	
	@PutMapping("/{catgId}")
	public ResponseEntity<Category> updateCategoryHandler(@Valid @RequestBody Category category, @PathVariable ("catgId") Integer catgId  )  throws CategoryException{
		
		return new ResponseEntity<>(cService.updateCategory(category,catgId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{catgId}")
	public ResponseEntity<Category>  removeCategory( @PathVariable ("catgId") Integer categoryId) throws CategoryException{
		return new ResponseEntity<>(cService.removeCategory(categoryId),HttpStatus.ACCEPTED);
		
	}
}
