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
	public ResponseEntity<User> getSingleUser(@PathVariable int userId)
	{
		User user1 = userservice.getUser(userId);
		return ResponseEntity.ok(user1);
		
	}
	
	@GetMapping(value = "api/user")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userservice.getAllUser();
		return ResponseEntity.ok(users);
		}
	
}