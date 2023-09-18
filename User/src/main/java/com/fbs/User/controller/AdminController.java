package com.fbs.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbs.User.entity.Admin;
import com.fbs.User.model.AuthRequest;
import com.fbs.User.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
		try {
			Admin admin = adminService.logIn(authRequest.getUsername(), authRequest.getPassword());
			return ResponseEntity.ok(admin);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
