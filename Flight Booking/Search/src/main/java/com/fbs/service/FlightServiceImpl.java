package com.fbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.entity.Flight;
import com.fbs.exception.FlightNotFoundException;
import com.fbs.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public List<Flight> flightSearch(String source, String destination, String date) {
		return flightRepo.findBySourceDestinationAndDate(source, destination, date).orElseThrow(()->new FlightNotFoundException("Not Found"));
	}

	@Override
	public Flight addFlight(Flight flight) {
		return flightRepo.save(flight);
	}

}
