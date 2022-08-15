package com.foodDelivery.serviceLayer.Category;

import java.util.List;

import com.foodDelivery.entity.Category;
import com.foodDelivery.exceptions.CategoryException;


public interface CategoryService {
	
	public Category addCategory (Category cat) throws CategoryException ;
	
	public Category updateCategory (Category cat, Integer catgId) throws CategoryException; 
	
	public Category removeCategory (Integer categoryId) throws CategoryException;
	
	public List <Category> viewAllCategory () throws CategoryException; 

}
