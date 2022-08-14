package com.foodDelivery.dataAcessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	@Query ("from Category catg where catg.categoryName=?1")
    public Category viewCategoryByName(String categoryName);

	
}
