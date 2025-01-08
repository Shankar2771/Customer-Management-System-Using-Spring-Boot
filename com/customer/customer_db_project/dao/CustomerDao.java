package com.customer.customer_db_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.customer_db_project.dto.Customer;
import com.customer.customer_db_project.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(int id) {
	   customerRepository.deleteById(id);
	}
	
	public Optional<Customer> fetchCustomerById(int id){
		return customerRepository.findById(id);
	}
	
	public List<Customer> fetchAllCustomer() {
		return customerRepository.findAll();
	}	
}
