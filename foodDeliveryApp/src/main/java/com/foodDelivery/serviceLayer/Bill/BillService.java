package com.foodDelivery.serviceLayer.Bill;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.foodDelivery.entity.Bill;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.exceptions.BillException;

@Service
public interface BillService {
    public Bill genrateBill(Customer customer);
    public Bill updateBill(Bill bill) throws BillException;
    public Bill removeBill(Integer billId) throws BillException;
    public List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate);
    public List<Bill> viewBills(Integer customerId);
}
