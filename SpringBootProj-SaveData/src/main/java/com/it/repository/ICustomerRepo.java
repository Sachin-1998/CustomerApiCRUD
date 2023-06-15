package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer>{

}
