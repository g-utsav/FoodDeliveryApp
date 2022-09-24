package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.Item;

public class CartItemDTO {

	private Item item;
	private CustomerToken customerToken;

	public CartItemDTO() {
		super();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public CustomerToken getCustomerToken() {
		return customerToken;
	}

	public void setCustomerToken(CustomerToken customerToken) {
		this.customerToken = customerToken;
	}

	@Override
	public String toString() {
		return "ItemDTO [item=" + item + ", customerToken=" + customerToken + "]";
	}
	
}
