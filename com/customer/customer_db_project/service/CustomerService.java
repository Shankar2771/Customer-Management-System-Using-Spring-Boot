package com.customer.customer_db_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer.customer_db_project.dao.CustomerDao;
import com.customer.customer_db_project.dto.Customer;
import com.customer.customer_db_project.util.ResponseStructure;


@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
//	----------------------Save Customer----------------------------
	
	public ResponseStructure<Customer> saveCustomer(Customer customer){
		customerDao.saveCustomer(customer);
		ResponseStructure<Customer> responseStructure =new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Customer data Saved");
		responseStructure.setData(customer);
		return responseStructure;
	}
	
 // ---------------------------Update Customer-------------------------------
	
	public ResponseStructure<Customer> updateCustomer(Customer customer) {
		Optional<Customer> optional = customerDao.fetchCustomerById(customer.getId());
		 ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		    if (optional.isPresent()) {
		        Customer updateCustomer = customerDao.updateCustomer(customer);
		        responseStructure.setStatusCode(HttpStatus.OK.value());
		        responseStructure.setMessage("Customer data Updated Successfully");
		        responseStructure.setData(updateCustomer);
		    } else {
		        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		        responseStructure.setMessage("Customer Not Found");
		        responseStructure.setData(null);
		    }
		    return responseStructure;
	}
//	---------------------------Delete Customer--------------------------------
	
	public ResponseStructure<String> deleteById(int id) {
	    Optional<Customer> optional = customerDao.fetchCustomerById(id);
	    ResponseStructure<String> responseStructure = new ResponseStructure<>();
	    if (optional.isPresent()) {
	        customerDao.deleteCustomer(id);
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setMessage("Customer Deleted Successfully");
	        responseStructure.setData("Deleted ID: " + id);
	    } else {
	        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        responseStructure.setMessage("Customer Not Found");
	        responseStructure.setData(null);
	    }
	    return responseStructure;
	}
//	----------------------------Fetch By ID--------------------------------
	
	public ResponseStructure<Customer> fetchCustomerById(int id) {
	Optional<Customer> optional=customerDao.fetchCustomerById(id);
	ResponseStructure<Customer> responseStructure =new ResponseStructure<>();
	if(optional.isPresent()) {
	responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
	responseStructure.setMessage("Customer Present");
	responseStructure.setData(optional.get());
	return responseStructure;
	}else {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Customer not Present");
		responseStructure.setData(null);
		return responseStructure;
	}
	}
	
	// ---------------------FetchAll Customer-------------------
	
	public ResponseStructure<List<Customer>> fetchAllCustomer() {
		List<Customer> customers = customerDao.fetchAllCustomer();
	    ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
	    responseStructure.setStatusCode(HttpStatus.OK.value());
	    responseStructure.setMessage("Customers Data Fetched Successfully");
	    responseStructure.setData(customers);
	    return responseStructure;
	}
}
