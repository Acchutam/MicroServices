package com.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.service.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping( value = "api/user")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1=userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping(value = "api/user/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker" ,fallbackMethod="ratingHotelFallback" )
	public ResponseEntity<User> getSingleUser(@PathVariable int userId)
	{
		User user1 = userservice.getUser(userId);
		return ResponseEntity.ok(user1);
		
	}
	
	//fallback method for circuit breaker 
	//return type of fallback should be same 
	public ResponseEntity<User> ratingHotelFallback(int userId,Exception ex)
	{
		User user=User.builder().
				email("dummy@gmail.com").
				name("dummy").
				about("This is dummy user").
				build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "api/user")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userservice.getAllUser();
		return ResponseEntity.ok(users);
		}
	
}
