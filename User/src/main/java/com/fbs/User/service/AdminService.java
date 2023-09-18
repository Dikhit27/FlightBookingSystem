package com.fbs.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.User.entity.Admin;
import com.fbs.User.repo.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;

	public Admin logIn(String username, String password) {

		Admin admin = adminRepo.findByUsername(username).orElseThrow(()-> new RuntimeException("Invalid password or username"));
		
		if(!admin.getPassword().equals(password)) {
			throw new RuntimeException("Invalid password or username");
		}
		
		return admin;
	  
	}

}
