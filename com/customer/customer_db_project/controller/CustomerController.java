package com.customer.customer_db_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customer_db_project.dto.Customer;
import com.customer.customer_db_project.service.CustomerService;
import com.customer.customer_db_project.util.ResponseStructure;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
//	http://localhost:8080/customer
	@PostMapping
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping
	public ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
//	http://localhost:8080/customer/delete/2
	@DeleteMapping("/delete/{id}")
	public ResponseStructure<String> deleteCustomer(@PathVariable int id) {
	    return customerService.deleteById(id);
	}
	
//	http://localhost:8080/customer/getAll
	@GetMapping("/getAll")
	public ResponseStructure<List<Customer>> fetchAllCustomer() {
	    return customerService.fetchAllCustomer();
	}
	
//	http://localhost:8080/customer/1
	@GetMapping("/{id}")
	public ResponseStructure<Customer> fetchCustomerById(@PathVariable int id) {
		return customerService.fetchCustomerById(id);
	}
}
