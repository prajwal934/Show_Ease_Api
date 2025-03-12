package com.praj.showease.test.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.praj.showease.test.dto.CustomerDto;
import com.praj.showease.test.model.Customer;
import com.praj.showease.test.utility.ResponseStructure;

public interface CustomerService {
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDto customerDto);
	
	public ResponseEntity<ResponseStructure<Customer>> findByCustomerId(String custId);
	
	public ResponseEntity<ResponseStructure<Customer>> updateByCustomerId(String custId, CustomerDto customerDto);
	
	public ResponseEntity<ResponseStructure<Customer>> deleteByCustomerId(String custId);
	
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers();
}
