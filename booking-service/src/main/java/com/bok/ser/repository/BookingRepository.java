package com.bok.ser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bok.ser.entity.BookingFlight;

@Repository
public interface BookingRepository extends MongoRepository<BookingFlight, Long> {

	
}
