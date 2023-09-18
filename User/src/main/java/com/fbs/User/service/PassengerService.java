package com.fbs.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.User.entity.Passengers;
import com.fbs.User.repo.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;

	public Passengers logIn(String username, String password) {

		Passengers passenger = passengerRepo.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Invalid password or username"));

		if (!passenger.getPassword().equals(password)) {
			throw new RuntimeException("Invalid password or username");
		}

		return passenger;

	}
}
