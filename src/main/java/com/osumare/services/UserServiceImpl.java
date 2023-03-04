package com.osumare.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osumare.entity.User;
import com.osumare.exceptions.ResourceNotFoundException;
import com.osumare.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		String s=UUID.randomUUID().toString();
		user.setUserId(s);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not exist"));
	}

	@Override
	public User update(String id, User user) {
		
		user.setUserId(id);
		User user1=userRepository.save(user);
		return user1;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
