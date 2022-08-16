package com.foodDelivery.serviceLayer.admin;

import com.foodDelivery.entity.dto.AdminDto;
import com.foodDelivery.entity.dto.CustomerToken;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.UserAccessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.exceptions.UserNotLoggedInException;

public interface AdminService {

	public AdminDto addAdmin(String token, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public AdminDto removeAdmin(String token, String mToken, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public boolean verifyAdmin(CustomerToken cToken,Integer custId) throws AdminAcessNotGrantedException ;
	
	public boolean verifyUser(CustomerToken cToken) throws UserAccessNotGrantedException,UserNotFound,UserNotLoggedInException;
	
}
