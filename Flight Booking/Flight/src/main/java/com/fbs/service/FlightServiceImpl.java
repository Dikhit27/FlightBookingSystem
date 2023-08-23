package com.fbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.entity.Flight;
import com.fbs.exception.FlightNotFoundException;
import com.fbs.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepo.save(flight);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		Flight f = flightRepo.findById(flight.getId())
				.orElseThrow(() -> new FlightNotFoundException("Cannot find flight"));
		return flightRepo.save(flight);
	}

	@Override
	public String deleteFlight(long id) {
		Flight f = flightRepo.findById(id).orElseThrow(() -> new FlightNotFoundException("Cannot find flight"));
		flightRepo.deleteById(id);
		return "Successfully Deleted";
	}

	@Override
	public List<Flight> getAll() {
		// TODO Auto-generated method stub
		List<Flight> list = flightRepo.findAll();
		return list;
	}

	@Override
	public Flight getById(long id) {
		// TODO Auto-generated method stub
		Flight f = flightRepo.findById(id).orElseThrow(() -> new FlightNotFoundException("Cannot find flight"));
	    return f;
	}

}
