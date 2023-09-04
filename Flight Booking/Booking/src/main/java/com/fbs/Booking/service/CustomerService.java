package com.fbs.Booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fbs.Booking.entity.Customer;

@Service
public interface CustomerService {

	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	String deleteCustomer(long id);
	Customer getCustomerById(long id);
	List<Customer> getAllCustomer();
	
}
