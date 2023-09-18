package com.fbs.User.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passengers extends User{

	private String firstName;
	private String lastName;
	private String gender;
}
