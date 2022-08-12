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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Restaurant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer resturantId;

	@NotNull
	private String restaurantName;

	@NotNull
	private String manager;
	
	@Size(min=10,max=10)
	private Integer contactNumber;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	
	//@Autowired
	@ManyToMany(cascade = CascadeType.ALL)
	List<Item> itemList=new ArrayList<>();
	
	


}
