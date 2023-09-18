package com.fbs.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("checkedPassengers")
public class CheckIn{

	@Id
	private long checkedInId;
	private long bookingId;
	
}
