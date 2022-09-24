package com.foodDelivery.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Embeddable
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer categoryId;
	
	@NotNull
	private String categoryName;

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
