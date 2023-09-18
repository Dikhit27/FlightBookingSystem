package com.bok.ser.entity;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	private long id;
	private String flightName;
	private String source;
	private String destination;
	private String date;
	private long fare;
}
