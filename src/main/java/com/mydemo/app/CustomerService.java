package com.mydemo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Transactional(readOnly = true)
	public Page<Customer> findAllCustomers() {

		Pageable pageable = PageRequest.of(0, 10);

		return repo.findByBatch(4, pageable);
	}
}
