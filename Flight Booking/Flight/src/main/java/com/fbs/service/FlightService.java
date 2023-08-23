package com.fbs.service;

import java.util.List;

import com.fbs.entity.Flight;

public interface FlightService {

	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public String deleteFlight(long id);
	public List<Flight> getAll();
	public Flight getById(long id);
}
