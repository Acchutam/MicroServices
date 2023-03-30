package com.user.service.service;

import java.util.List;

import com.user.service.entities.User;

public interface UserService {

	//Create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user of given userID
	User getUser(int userId); 
	
	
	
}
