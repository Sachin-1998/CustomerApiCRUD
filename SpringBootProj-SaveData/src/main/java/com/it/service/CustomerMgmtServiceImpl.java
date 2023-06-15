package com.it.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.CustomerDto;
import com.it.entity.Customer;
import com.it.repository.ICustomerRepo;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto saveCustomerInfo(CustomerDto customerdto) {
		Customer customer = this.modelMapper.map(customerdto, Customer.class);
		Customer cust = repo.save(customer);
		return this.modelMapper.map(cust, CustomerDto.class);

	}

	@Override
	public List<CustomerDto> getAllCustomer() 
	{
		List<Customer> cust=repo.findAll();
		List<CustomerDto> custdtos=cust.stream().map(customer-> this.modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
		return custdtos;
	}

	@Override
	public CustomerDto getCustomerById(Integer id)
	{
		Customer cust=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Id is not found"));
		return this.modelMapper.map(cust, CustomerDto.class);
	}

	@Override
	public CustomerDto updateById(CustomerDto custdto, Integer id) 
	{
		Customer cust=repo.findById(id).orElseThrow(()-> new IllegalArgumentException());
		cust.setName(custdto.getName());
		cust.setContractType(custdto.getContractType());
		cust.setAccountType(custdto.getAccountType());
		cust.setBusinessRequirements(custdto.getBusinessRequirements());
		cust.setDetails(custdto.getDetails());
		Customer customer=repo.save(cust);
		return this.modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public void deleteById(Integer id) {
		Customer cust=repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Id is not found to delete"));
		this.repo.deleteById(id);
	}

}
