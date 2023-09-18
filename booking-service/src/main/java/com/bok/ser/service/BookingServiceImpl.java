package com.bok.ser.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bok.ser.entity.BookingFlight;
import com.bok.ser.exception.FlightNotFoundException;
import com.bok.ser.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public BookingFlight bookFlight(BookingFlight bookingFlight) {
		Optional<BookingFlight> book = bookingRepo.findById(bookingFlight.getId());
		if(book.isPresent()) {
			throw new FlightNotFoundException("Already Booked with this "+bookingFlight.getId());
		}
		return bookingRepo.save(bookingFlight);
	}

	@Override
	public BookingFlight getBookingById(long bookingId) {
		return bookingRepo.findById(bookingId).get();
	}

	@Override
	public BookingFlight checkedIn(long id){
		BookingFlight b = bookingRepo.findById(id).orElseThrow(()->new FlightNotFoundException("Flight Not found"));
		b.setCheckedIn(true);
		return bookingRepo.save(b);
	}

}
