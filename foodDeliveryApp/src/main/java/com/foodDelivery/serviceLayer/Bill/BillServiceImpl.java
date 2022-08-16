package com.foodDelivery.serviceLayer.Bill;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelivery.dataAcessLayer.BillDao;
import com.foodDelivery.entity.Bill;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.Item;
import com.foodDelivery.exceptions.BillException;


@Service
public class BillServiceImpl implements BillService{
     @Autowired
     private BillDao billDao;	
	
     @Override
	public Bill genrateBill(Customer customer) {
    	 
    	 Bill bill = new Bill();
    	 bill.setCustomer(customer);
    	 bill.setTotalItems(customer.getCart().getCartItems().size());
    	 bill.setBillDateTime(LocalDateTime.now());
    	 Double totalCost = (double) 0;
    	 List<Item> items = customer.getCart().getCartItems();
    	 for(Item  i:items) {
    		 totalCost += i.getCost();
    	 }
		 bill.setTotalCost(totalCost);
		Bill insertedBill = billDao.save(bill);
		
		return insertedBill;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		
		Optional<Bill> opt = billDao.findById(bill.getBillId());
		
		if(opt.isPresent())
		{
			Bill newBill = billDao.save(bill);
			return newBill;
			
		}
		else
		{
		    throw new BillException("Bill not found...");
		}
	}

	@Override
	public Bill removeBill(Integer billId) throws BillException {
       
		Optional<Bill> opt = billDao.findById(billId);
		
		if(opt.isPresent())
		{
			billDao.delete(opt.get());;
			return opt.get();
			
		}
		else
		{
		    throw new BillException("Bill not found...");
		}
	
	}

	@Override
	public List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate) {
		  List<Bill> bills = billDao.getBillsByDate(startDate, endDate);
		  
		  return bills;
	}

	@Override
	public List<Bill> viewBills(Integer customerId){
		List<Bill> bills = billDao.getBillsByCustomer(customerId);
		
		return bills;
	}

	@Override
	public Bill viewBill(Integer billId) throws BillException {
		
		Optional<Bill> opt = billDao.findById(billId);
		
		if(opt.isPresent())
			return opt.get();
		else
			throw new BillException("Bill not Found with id : "+billId);
	}

}
