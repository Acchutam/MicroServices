package com.rating.services;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getRatingByUserId(int userId);
	
	List<Rating> getRatingByHotelId(int hotelId);
	
	
}
