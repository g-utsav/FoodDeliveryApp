package com.foodDelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Category;
import com.foodDelivery.entity.dto.CategoryDTO;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.CategoryException;
import com.foodDelivery.serviceLayer.Category.CategoryService;
import com.foodDelivery.serviceLayer.admin.AdminService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private AdminService aServ;
	
	@Autowired
	private CategoryService cService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategoryHandler(@Valid @RequestBody CategoryDTO categoryDTO )  throws CategoryException, AdminAcessNotGrantedException{
		if(!aServ.verifyAdmin(categoryDTO.getCustomerToken(), categoryDTO.getCustomerToken().getCustId())) {
			
		}
		return new ResponseEntity<>(cService.addCategory(categoryDTO.getCategory()),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{catgId}")
	public ResponseEntity<Category> updateCategoryHandler(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable ("catgId") Integer catgId  )  throws CategoryException, AdminAcessNotGrantedException{
		if(aServ.verifyAdmin(categoryDTO.getCustomerToken(), categoryDTO.getCustomerToken().getCustId())) {
			
		}
		
		return new ResponseEntity<>(cService.updateCategory(categoryDTO.getCategory(),catgId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{catgId}")
	public ResponseEntity<Category>  removeCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable ("catgId") Integer categoryId) throws CategoryException, AdminAcessNotGrantedException{
		if(aServ.verifyAdmin(categoryDTO.getCustomerToken(), categoryDTO.getCustomerToken().getCustId())) {
			
		}
		return new ResponseEntity<>(cService.removeCategory(categoryId),HttpStatus.ACCEPTED);
		
	}

    @GetMapping(value = "/")
    public ResponseEntity<String> generalMessage (){
        return new ResponseEntity<>("This is Category Controller visit https://github.com/g-utsav/FoodDeliveryApp for URL extension Detail.",HttpStatus.OK);
    }
}
