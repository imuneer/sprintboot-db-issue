package com.mydemo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public ResponseEntity<Page<Customer>> indexPath(Model model) {

		Page<Customer> customers = this.service.findAllCustomers();

		model.addAttribute("customers", customers);
		// setting null before sending to client
		// this is for demonstration purpose only
		customers.getContent().forEach(i -> i.setSecret(null));

		return ResponseEntity.ok(customers);
	}
}
