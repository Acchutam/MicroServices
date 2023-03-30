package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.entities.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer>{

	
	
	
}
