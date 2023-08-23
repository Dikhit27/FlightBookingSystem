package com.fbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbs.entity.Flight;
import com.fbs.service.FlightServiceImpl;

@RestController
public class FlightController {

	@Autowired
	private FlightServiceImpl flightService;
	
	@PostMapping("/flight/add")
	public ResponseEntity<Object> addFlight(@RequestBody Flight flight){
		Flight f = flightService.addFlight(flight);
		return new ResponseEntity<>(f,HttpStatus.CREATED);
	}
	
	@PutMapping("/flight/update")
	public ResponseEntity<Object> updateFlight(@RequestBody Flight flight){
		Flight f = flightService.updateFlight(flight);
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@DeleteMapping("/flight/delete/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable long id){
		 flightService.deleteFlight(id);
		return new ResponseEntity<>("Successfully Deleted the Flight",HttpStatus.OK);
	}
	

	@GetMapping("/flight/get/{id}")
	public ResponseEntity<Object> getFlightById(@PathVariable long id){
		 Flight f=flightService.getById(id);
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@GetMapping("/flight/get/all")
	public  ResponseEntity<Object> getAllFlight(){
		 List<Flight> list=flightService.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
}
