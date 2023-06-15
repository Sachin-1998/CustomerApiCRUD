package com.it.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.CustomerDto;
import com.it.service.CustomerMgmtServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customerapi")
public class CustomerMgmtController 
{
	@Autowired
	private CustomerMgmtServiceImpl service;

	@PostMapping("/add")
	public ResponseEntity<CustomerDto> registerCustomer(@Valid @RequestBody CustomerDto custdto) 
	{
		CustomerDto customer = service.saveCustomerInfo(custdto);
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<List<CustomerDto>> fetchAllCustomers()
	{
		List<CustomerDto> customers=service.getAllCustomer();
		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CustomerDto> fetchCustomerDetailsById( @PathVariable Integer id)
	{
		CustomerDto cust=service.getCustomerById(id);
		return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDto> modifyCustomerDetailsById( @Valid @RequestBody CustomerDto custdto,@PathVariable Integer id)
	{
		CustomerDto cust=service.updateById(custdto, id);
		return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerDto> removeCustById( @PathVariable Integer id)
	{
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
