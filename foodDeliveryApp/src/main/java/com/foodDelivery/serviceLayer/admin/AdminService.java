package com.foodDelivery.serviceLayer.admin;

import com.foodDelivery.entity.dto.AdminDto;
import com.foodDelivery.entity.dto.CustomerToken;
import com.foodDelivery.entity.dto.RestaurantDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;

public interface AdminService {

	public AdminDto addAdmin(String token, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public AdminDto removeAdmin(String token, String mToken, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public boolean verifyAdmin(CustomerToken cToken,Integer custId) throws AdminAcessNotGrantedException ;
	
}
