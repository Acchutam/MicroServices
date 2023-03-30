package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.HotelService;
import com.hotelservice.entities.Hotel;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping(value="api/hotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		 return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
	}
	
	@GetMapping(value="api/hotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.get(id));
	}
	
	@GetMapping(value="api/hotel")
	public ResponseEntity<List<Hotel>>getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
}
