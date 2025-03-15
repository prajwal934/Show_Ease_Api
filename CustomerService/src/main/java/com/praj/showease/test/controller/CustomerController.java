package com.praj.showease.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praj.showease.test.dto.CustomerDto;
import com.praj.showease.test.model.Customer;
import com.praj.showease.test.service.CustomerService;
import com.praj.showease.test.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.saveCustomer(customerDto);
	}
	
	    
	@PutMapping("/{custId}")
	public ResponseEntity<ResponseStructure<Customer>> updateByCustId(@PathVariable("custId") String custId, @RequestBody CustomerDto customerDto) {
		return customerService.updateByCustomerId(custId, customerDto);
	}
 
	/* This Method Deletes the customer by their custId; */
	@DeleteMapping("/{custId}")
	public ResponseEntity<ResponseStructure<Customer>> deleteByCustomerId(@PathVariable("custId") String custId) {
		return customerService.deleteByCustomerId(custId);
	}
	
	/*This Method retrieves all customers (without custId in the URL)*/
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers() {
		return customerService.findAllCustomers();
	}
	
}
