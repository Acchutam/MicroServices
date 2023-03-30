package com.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Rating;
import com.rating.services.RatingService;

@RestController
public class RatingController {
	@Autowired
	private RatingService service;
	
	
	@PostMapping(value="api/rating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		 return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
	}
	
	@GetMapping(value="api/rating")
	public ResponseEntity<List<Rating>> getRatings()
	{
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping(value="api/rating/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable int userId)
	{
		return ResponseEntity.ok(service.getRatingByUserId(userId));
	}
	
	@GetMapping(value="api/rating/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable int hotelId)
	{
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
	}
	
	
}
