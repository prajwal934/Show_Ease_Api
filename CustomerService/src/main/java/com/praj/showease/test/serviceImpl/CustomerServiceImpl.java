package com.praj.showease.test.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.praj.showease.test.dto.CustomerDto;
import com.praj.showease.test.exceptions.CustomerNotDeletedException;
import com.praj.showease.test.exceptions.CustomerNotFoundByIdException;
import com.praj.showease.test.model.Customer;
import com.praj.showease.test.repository.CustomerRepository;
import com.praj.showease.test.service.CustomerService;
import com.praj.showease.test.utility.ResponseStructure;

@Service
public class CustomerServiceImpl  implements CustomerService{


	private CustomerRepository customerRepository;
	private ResponseStructure<Customer> responseStructure;
	private ResponseStructure<List<Customer>> rs;



	public CustomerServiceImpl(CustomerRepository customerRepository, ResponseStructure<Customer> responseStructure,
			ResponseStructure<List<Customer>> rs) {
		super();
		this.customerRepository = customerRepository;
		this.responseStructure = responseStructure;
		this.rs = rs;
	}




	@Override
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDto customerDto) {	

		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Customer Data Saved Successfully!")
				.setData(customerRepository.save(mapToCustomer(customerDto))));
	}

	private Customer mapToCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub

		String randomCustId = UUID.randomUUID().toString(); //for generating unique custId;
		return  Customer.builder()
				.custName(customerDto.getCustName())
				.custEmail(customerDto.getCustEmail())
				.custPh(customerDto.getCustPh())
				.custAddress(customerDto.getCustAddress())
				.custId(randomCustId).build();
	}



	@Override
	public ResponseEntity<ResponseStructure<Customer>> findByCustomerId(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Customer>> updateByCustomerId(String custId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer updateCustomer = mapToCustomer(customerDto);
		return customerRepository.findById(custId).map(exCust -> {
			updateCustomer.setCustId(exCust.getCustId());
			exCust = customerRepository.save(updateCustomer);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage("Cust Data Updated Successfully!")
					.setData(updateCustomer));
		}).orElseThrow( () -> new CustomerNotFoundByIdException("Customer Not Found!"));
	}


	@Override
	public ResponseEntity<ResponseStructure<Customer>> deleteByCustomerId(String custId) {
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findById(custId);
		
		return optional.map(customer -> {customerRepository.delete(customer);
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Customer Data Deleted Successfully!"));
		}).orElseThrow( () -> new CustomerNotDeletedException("Customer Not Deleted, try agian!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Customer Data Fetched Successfully!")
				.setData(customerRepository.findAll()));
	}

	
}
