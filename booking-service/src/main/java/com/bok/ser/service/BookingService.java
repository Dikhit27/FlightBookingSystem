package com.bok.ser.service;

import org.springframework.stereotype.Service;

import com.bok.ser.entity.BookingFlight;

@Service
public interface BookingService {
	
	 BookingFlight bookFlight(BookingFlight bookingFlight);
	
	 BookingFlight getBookingById(long bookingId);
	
	 BookingFlight checkedIn(long id) ;
}
