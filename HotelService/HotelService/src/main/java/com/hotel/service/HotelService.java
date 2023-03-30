package com.hotel.service;

import java.util.List;

import com.hotelservice.entities.Hotel;

public interface HotelService {

	//create
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(int id);
	
}
