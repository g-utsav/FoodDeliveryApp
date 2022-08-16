package com.foodDelivery.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.entity.Bill;
import com.foodDelivery.entity.Customer;
import com.foodDelivery.entity.dto.BillDto;
import com.foodDelivery.exceptions.AdminAcessNotGrantedException;
import com.foodDelivery.exceptions.BillException;
import com.foodDelivery.serviceLayer.Bill.BillService;
import com.foodDelivery.serviceLayer.admin.AdminService;

@RestController
@RequestMapping("/bill")
public class BillController {
  
	@Autowired
	private BillService billService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/genrate")
	public ResponseEntity<Bill> genrateBillHandler(@RequestBody Customer customer){
		return new ResponseEntity<>(billService.genrateBill(customer),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<Bill> updateBillHandler(@RequestBody Bill bill) throws BillException{
		return new ResponseEntity<>(billService.updateBill(bill),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Bill> removeBillHandler(@PathVariable ("id") Integer id,@RequestBody BillDto billDto) throws BillException,AdminAcessNotGrantedException{
		if(!adminService.verifyAdmin(billDto.getCustomerToken(), billDto.getCustomerToken().getCustId())) ;
		
		return new ResponseEntity<>(billService.removeBill(id),HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Bill>> getBillsByDate(@RequestParam LocalDateTime startDate,@RequestParam LocalDateTime endDate){
		return new ResponseEntity<>(billService.viewBillsByDate(startDate, endDate),HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/customerId={id}")
	public ResponseEntity<List<Bill>> getBillByCustomerId(@PathVariable ("id") Integer id){
		return new ResponseEntity<>(billService.viewBills(id),HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable ("id") Integer id) throws BillException{
		return new ResponseEntity<>(billService.viewBill(id),HttpStatus.FOUND);
	}
}
