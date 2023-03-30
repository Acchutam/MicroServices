package com.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 

public class Rating {

	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
	
	
}
