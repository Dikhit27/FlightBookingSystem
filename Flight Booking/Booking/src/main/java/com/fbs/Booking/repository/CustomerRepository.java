package com.fbs.Booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fbs.Booking.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
