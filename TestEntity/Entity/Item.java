package com.masai.Entity;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer itemId;
	
	@NotNull
	private String itemName;
	
	@Min(1)
	private Integer quantity;
	
	@NotNull
	private double cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "itemList")
	List<Restaurant> restaurantList=new ArrayList<>();
	


}
