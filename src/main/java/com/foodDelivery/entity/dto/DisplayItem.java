package com.foodDelivery.entity.dto;

public class DisplayItem {
	
	private String itemName;
	private String categoryName;
	private Double itemCost;
	private String restaurantName;
	
	public DisplayItem(String itemName, String categoryName, Double itemCost, String restaurantName) {
		super();
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.itemCost = itemCost;
		this.restaurantName = restaurantName;
	}
	
	public DisplayItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	@Override
	public String toString() {
		return "DisplayItem [itemName=" + itemName + ", categoryName=" + categoryName + ", itemCost=" + itemCost
				+ ", restaurantName=" + restaurantName + "]";
	}
	
	

}
