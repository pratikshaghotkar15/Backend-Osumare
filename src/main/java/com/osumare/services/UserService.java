package com.osumare.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.osumare.entity.User;

public interface UserService {
	

	//create user
	User create(User user);
	
	//get users
	List<User> getAll();
	
	//get user by id 
	User getById(String id);
	
	//update user
	User update(String id,User user);
	
	//delete user
	void delete(String id);
	
	
	
	
}
