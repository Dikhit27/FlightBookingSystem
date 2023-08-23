package com.fbs.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("flight")
public class Flight {
	
	@Id
	private long id;
	
	private String flightName;
	private String source;
	private String destination;
	private String date;
	private String fare;
	
	
	

}
