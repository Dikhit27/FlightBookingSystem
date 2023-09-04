package com.fbs.Booking.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
}
