package com.fbs.Booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbs.Booking.service.CustomerServiceImpl;
import  com.fbs.Booking.entity.Customer;


@RestController
@RequestMapping("/booking")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;

	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		var newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
		var newCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>("Customer successfully deleted", HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable long id) {
		var newCustomer=customerService.getCustomerById(id);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	@GetMapping("/Customer/getAll")
	public ResponseEntity<Object> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomer();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


	

}
