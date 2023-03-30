package com.rating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository repository;
	
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
		
	}

	@Override
	public List<Rating> getRatingByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return repository.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
