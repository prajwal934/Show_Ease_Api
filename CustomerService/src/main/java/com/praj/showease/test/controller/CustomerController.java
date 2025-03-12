package com.praj.showease.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}
