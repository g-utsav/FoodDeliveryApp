package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.Category;

public class CategoryDTO {

	private Category category;
	private CustomerToken customerToken;
	
	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(Category category, CustomerToken customerToken) {
		super();
		this.category = category;
		this.customerToken = customerToken;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CustomerToken getCustomerToken() {
		return customerToken;
	}
	public void setCustomerToken(CustomerToken customerToken) {
		this.customerToken = customerToken;
	}
	@Override
	public String toString() {
		return "CategoryDTO [category=" + category + ", customerToken=" + customerToken + "]";
	}

}
