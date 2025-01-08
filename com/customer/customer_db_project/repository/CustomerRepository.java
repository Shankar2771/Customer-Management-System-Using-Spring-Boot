package com.customer.customer_db_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.customer_db_project.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
