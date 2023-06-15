package com.it.service;

import java.util.List;

import com.it.dto.CustomerDto;


public interface ICustomerMgmtService 
{
	public CustomerDto saveCustomerInfo(CustomerDto customer);
	
	public List<CustomerDto> getAllCustomer();
	
	public CustomerDto getCustomerById(Integer id);
	
	public CustomerDto updateById(CustomerDto custdto,Integer id);
	
	public void deleteById(Integer id);

}
