package com.fbs.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.Booking.entity.Customer;
import com.fbs.Booking.exception.CustomerNotFoundException;
import com.fbs.Booking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customerRepository.findById(customer.getId()).orElseThrow(()-> new CustomerNotFoundException("Not found"));
		return customerRepository.save(customer);
	}

	@Override
	public String deleteCustomer(long id) {
		Customer cus=customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Not found"));
		customerRepository.deleteById(cus.getId());
		return "SuccessFully Deleted";
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer cus=customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Not found"));
		return cus;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

}
