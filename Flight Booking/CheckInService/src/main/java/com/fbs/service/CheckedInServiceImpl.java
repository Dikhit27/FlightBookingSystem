package com.fbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.entity.CheckIn;
import com.fbs.exception.FlightNotFoundException;
import com.fbs.repository.CheckedInRepository;


@Service
public class CheckedInServiceImpl implements CheckedInService {

	@Autowired
	private CheckedInRepository checkInRepo;

	@Override
	public String flightCheckIn(CheckIn checkIn) {

		checkInRepo.save(checkIn);
		return "You are checkedIn and your checkInId is "+checkIn.getCheckedInId();
	}

	@Override
	public CheckIn getCheckIn(long id) {

		CheckIn checkIn = checkInRepo.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight Not Found"));

		return checkIn;
	}

	@Override
	public List<CheckIn> getAllCheckedPassengers() {
		return checkInRepo.findAll();
	}

}
