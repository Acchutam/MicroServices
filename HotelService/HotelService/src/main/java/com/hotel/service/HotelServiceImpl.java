package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import com.hotelservice.entities.Hotel;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository repository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Hotel get(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with giiven id not found!!:"+id));
	}

}
