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
import javax.validation.constraints.NotNull;
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
	
//	@Size(min=10,max=10)
	private Integer contactNumber;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	
	//@Autowired
	@ManyToMany(cascade = CascadeType.ALL)
	List<Item> itemList=new ArrayList<>();

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

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Restaurant [resturantId=" + resturantId + ", restaurantName=" + restaurantName + ", manager=" + manager
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", itemList=" + itemList + "]";
	}

	public Restaurant(Integer resturantId, @NotNull String restaurantName, @NotNull String manager,
			Integer contactNumber, Address address, List<Item> itemList) {
		super();
		this.resturantId = resturantId;
		this.restaurantName = restaurantName;
		this.manager = manager;
		this.contactNumber = contactNumber;
		this.address = address;
		this.itemList = itemList;
	}

	public Restaurant() {
		super();
	}
	
	
	


}
