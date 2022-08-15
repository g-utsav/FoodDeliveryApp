package com.foodDelivery.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer itemId;
	
	@NotNull
	private String itemName;
	
	@NotNull
	private double cost;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	//@Autowired
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "itemList")
	List<Restaurant> restaurantList=new ArrayList<>();

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item() {
		super();
	}

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", cost=" + cost + ", category=" + category
				+ ", restaurantList=" + restaurantList + "]";
	}
	
}
