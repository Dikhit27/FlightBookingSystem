package com.bok.ser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bok.ser.entity.BookingFlight;
import com.bok.ser.entity.Flight;
import com.bok.ser.entity.User;
import com.bok.ser.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/book/{flightId}")
	public String book(@RequestBody User user, @PathVariable long flightId) {
		BookingFlight bookingFlight = new BookingFlight();
		
		bookingFlight.setId(user.getId());
		bookingFlight.setFirstName(user.getFirstName());
		bookingFlight.setLastName(user.getLastName());
		bookingFlight.setGender(user.getGender());
		
		Flight flight = restTemplate.getForObject("http://Flight-Service/flight/get/"+flightId, Flight.class);
		
		bookingFlight.setFlightId(flight.getId());
		bookingFlight.setFlightName(flight.getFlightName());
		bookingFlight.setSource(flight.getSource());
		bookingFlight.setDestination(flight.getDestination());
		bookingFlight.setDate(flight.getDate());
		
		BookingFlight bookedFlight = bookingService.bookFlight(bookingFlight);
		
		return "Your Booking is confirmed and your reference id is : " + bookedFlight.getId();
	}

	@GetMapping("/{id}")
	public Object getBookindById(@PathVariable long id) {
		return bookingService.getBookingById(id);
	}
	
	
	@PutMapping("/checkedIn/{id}")
	public ResponseEntity<Object> checkedIn(@PathVariable long id){
		BookingFlight b = bookingService.checkedIn(id);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
}
