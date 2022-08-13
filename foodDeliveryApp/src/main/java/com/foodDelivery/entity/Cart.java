package com.foodDelivery.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer cartId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> cartItems;


	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + "]";
	}

	public Cart(Integer cartId, List<Item> cartItems) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
	}

	public Cart() {
		super();
	}
	

	public Cart() {
	}

	public Cart(Integer cartId, List<Item> cartItems) {
		this.cartId = cartId;
		this.cartItems = cartItems;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"cartId=" + cartId +
				", cartItems=" + cartItems +
				'}';
	}
}
