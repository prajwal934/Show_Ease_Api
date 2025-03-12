package com.praj.showease.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praj.showease.test.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
