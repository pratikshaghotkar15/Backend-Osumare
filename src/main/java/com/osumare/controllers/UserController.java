package com.osumare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osumare.entity.User;
import com.osumare.services.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.create(user));
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getall(){
		return ResponseEntity.ok(userservice.getAll());
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getById(@PathVariable("userId") String id){
		return ResponseEntity.ok(userservice.getById(id));
	}
	
	
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> update(@PathVariable("userId") String id,@RequestBody User user){
		return ResponseEntity.ok(userservice.update(id, user));
		
	}
	
	
	@DeleteMapping("/users/{userId}")
	public void delete(@PathVariable("userId") String id) {
		userservice.delete(id);
	}

}
