package com.foodDelivery.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Restaurant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer resturantId;

	@NotNull
	private String restaurantName;

	@NotNull
	private String manager;
	
	@Pattern(regexp = "[0-9]{10}",message="Mobile should be 10 digit")
	private String contactNumber;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	
	//@Autowired
	@ManyToMany
	@JoinColumn(name="item_id", nullable = false)
	Set<Item> itemList=new HashSet<>();

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(Integer resturantId, @NotNull String restaurantName, @NotNull String manager,
			@Pattern(regexp = "[0-9]{10}", message = "Mobile should be 10 digit") String contactNumber, Address address,
			Set<Item> itemList) {
		super();
		this.resturantId = resturantId;
		this.restaurantName = restaurantName;
		this.manager = manager;
		this.contactNumber = contactNumber;
		this.address = address;
		this.itemList = itemList;
	}
	public Integer getResturantId() {
		return resturantId;
	}
	public void setResturantId(Integer resturantId) {
		this.resturantId = resturantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Item> getItemList() {
		return itemList;
	}
	public void setItemList(Set<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Restaurant [resturantId=" + resturantId + ", restaurantName=" + restaurantName + ", manager=" + manager
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", itemList=" + itemList + "]";
	}
	
	
		

}
