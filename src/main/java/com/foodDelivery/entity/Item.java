package com.foodDelivery.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Item {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO) 
		private Integer itemId;
		
		@NotNull
		private String itemName;
		
		@NotNull
		private Double cost;
		
		@OneToOne(cascade = CascadeType.PERSIST)
		private Category category;
		
		@ManyToMany
		@JsonIgnore
//		@JoinColumn(name="restaurantId")
		private Set<Restaurant> restaurants = new HashSet<>();
		


	public Item(Integer itemId, @NotNull String itemName, @NotNull Double cost, Category category,
				Set<Restaurant> restaurants) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.cost = cost;
			this.category = category;
			this.restaurants = restaurants;
		}
	
		public Item() {
			super();
			// TODO Auto-generated constructor stub
		}

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

		public Double getCost() {
			return cost;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemName=" + itemName + ", cost=" + cost + ", category=" + category
					+ ", restaurants=" + restaurants + "]";
		}

		public Set<Restaurant> getRestaurants() {
			return restaurants;
		}

		public void setRestaurants(Set<Restaurant> restaurants) {
			this.restaurants = restaurants;
		}

		
		
}
