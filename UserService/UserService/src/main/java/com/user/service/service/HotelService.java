package com.user.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Hotel;


@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService {

	
	@GetMapping(value="api/hotel/{id}")
	 Hotel getHotel(@PathVariable int id);
	
}
