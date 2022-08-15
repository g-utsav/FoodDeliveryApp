package com.foodDelivery.serviceLayer.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.CategoryDao;
import com.foodDelivery.entity.Category;
import com.foodDelivery.exceptions.CategoryException;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category addCategory(Category category)  throws CategoryException{

		boolean flag = true;
		if(category.getCategoryId()==null) {
			flag = false;
			
		}
		if(flag ) {
			Optional<Category> opt = categoryDao.findById(category.getCategoryId());

			if(opt.isPresent()) {
				throw new CategoryException("Category already present");
			}else {
				Category category1 = categoryDao.save(category);
				return category1;
			}
		}else {
			Category catg1= categoryDao.viewCategoryByName(category.getCategoryName());
			
			if(catg1==null) {
				categoryDao.save(category);				
				return category;
			}else {
				throw new CategoryException("Category already exists");
			}
			
		}
		

	}

	@Override
	public Category updateCategory(Category category, Integer catgId)  throws CategoryException{
		Optional<Category> opt = categoryDao.findById(catgId);

		if(opt.isPresent()) {
			category.setCategoryId(catgId);
			Category category1 = categoryDao.save(category);
			return category1;
		}else {
			throw new CategoryException("Category not present");
		}
	}

	@Override
	public Category removeCategory(Integer categoryId)  throws CategoryException{
		Optional<Category> opt = categoryDao.findById(categoryId);

		if(opt.isPresent()) {
			categoryDao.delete(opt.get());
			return opt.get();
		}else {
			throw new CategoryException("Category not found");
		}
	}


	@Override
	public List<Category> viewAllCategory() {
		List<Category> categories = categoryDao.findAll(); 
		return categories;
	}


}
