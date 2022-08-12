package com.masai.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Embeddable
@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	


}
