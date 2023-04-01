package com.user.service.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;

import com.user.service.repositories.UserRepository;

import exceptions.ResourceNotFoundException;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired 
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User>users =repository.findAll();
		for(User i : users)
		{
			Rating[] ratingArr = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+i.getUserId(), Rating[].class);
			List<Rating> ratings = Arrays.stream(ratingArr).collect(Collectors.toList());
			i.setRatings(ratings);
			for(Rating r : ratings)
			{
				Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/hotel/"+r.getHotelId(), Hotel.class);
				r.setHotel(hotel);
			}
		}
		
		
		return users;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		User user = repository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found !! :"+userId));
		
		Rating[] ratingArr = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+user.getUserId(), Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingArr).collect(Collectors.toList());
		
		user.setRatings(ratings);
		for(Rating r : ratings)
		{
			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/hotel/"+r.getHotelId(), Hotel.class);
			//Hotel hotel = hotelservice.getHotel(r.getHotelId());
			r.setHotel(hotel);
		}
		return user;
	}

}
