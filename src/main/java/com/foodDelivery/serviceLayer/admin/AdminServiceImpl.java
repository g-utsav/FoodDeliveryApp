package com.foodDelivery.serviceLayer.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.AdminDao;
import com.foodDelivery.dataAcessLayer.CustomerDao;
import com.foodDelivery.dataAcessLayer.SessionDAO;
import com.foodDelivery.entity.Admin;
import com.foodDelivery.entity.CurrentUserSession;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.dto.AdminDto;
import com.foodDelivery.entity.dto.CustomerToken;
import com.foodDelivery.entity.dto.RestaurantDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.UserAccessNotGrantedException;
import com.foodDelivery.exceptions.UserNotFound;
import com.foodDelivery.exceptions.UserNotLoggedInException;

@Service
public class AdminServiceImpl implements AdminService{

	private String masterToken = "ABz";
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private SessionDAO sDao;
	
	@Override
	public AdminDto addAdmin(String token, Integer custId) throws AdminAcessNotGrantedException,UserNotFound {
		System.out.println(token+" " +custId+" "+token != masterToken);
		if(!token.equals(masterToken)) {
			throw new AdminAcessNotGrantedException("UnAuthorised Access!");
		}
		
		Optional<Customer> opt = cDao.findById(custId);
		
		if(opt.isPresent()) {
			
			Admin a = aDao.findCustomerIdIfExist(custId);
			System.out.println(a+" "+opt.get());
			if(a == null) {
				Admin admin = new Admin();
				admin.setCustomer(opt.get());
				aDao.save(admin);
				return new AdminDto("Sucess",HttpStatus.CREATED);
			}else {
				return new AdminDto("Given User is Allready Admin",HttpStatus.ALREADY_REPORTED);
			}
			
		}else {
			throw new UserNotFound("User Not Found");
		}
	}

	@Override
	public AdminDto removeAdmin(String token, String mToken, Integer custId)
			throws AdminAcessNotGrantedException, UserNotFound {
		if(!mToken.equals(masterToken) && token == null) {
			throw new AdminAcessNotGrantedException("UnAuthorised Access!");
		}
		
		Optional<CurrentUserSession> cus = sDao.findByUuid(token);
		
		if(cus.isPresent() || masterToken.equals(mToken) ) {
			Admin admin = aDao.findCustomerIdIfExist(custId);
			if(admin != null) {
				aDao.delete(admin);
				return new AdminDto("Sucess",HttpStatus.ACCEPTED);
			}else {
				throw new UserNotFound("User Not Found");
				
			}
		}else {
			throw new AdminAcessNotGrantedException("UnAuthorised Access!");
		}
	}
	
	public boolean verifyAdmin(CustomerToken cToken, Integer custId)throws AdminAcessNotGrantedException {
		boolean flag = false;
		
		if(cToken.getMasterToken() != null) {
			if(cToken.getMasterToken().equals(masterToken)) {
				return true;
			}
		}
		
		if(custId != null) {
			Admin admin = aDao.findCustomerIdIfExist(custId);
			if(admin != null) {
				return true;
			}
		}
		
		if(cToken.getToken() != null) {
			Optional<CurrentUserSession> cus = sDao.findByUuid(cToken.getToken());
			if(cus.isPresent()) {
				Admin admin = aDao.findCustomerIdIfExist(cus.get().getCustomerId());
				if(admin != null) {
					return true;
				}
			}
		}
		
		throw new AdminAcessNotGrantedException("Access Denied!");
	}
	
	public boolean verifyUser(CustomerToken cToken) throws UserAccessNotGrantedException,UserNotFound,UserNotLoggedInException{
		
		Optional<Customer> opt = cDao.findById(cToken.getCustId());
		if(!opt.isPresent()) {
			throw new UserNotFound("No user Found. SignIn First");
		}
		
		Optional<CurrentUserSession> cus = sDao.findByUuid(cToken.getToken());
		if(!cus.isPresent()) {
			throw new UserNotLoggedInException("User is Not Logged In! Login First!.");
		}
		
		return true;
	}
	
}
