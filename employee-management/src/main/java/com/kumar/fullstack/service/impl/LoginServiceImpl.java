package com.kumar.fullstack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumar.fullstack.model.User;
import com.kumar.fullstack.repos.UserRepository;
import com.kumar.fullstack.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User login(String emailId,String password) {
		User user= userRepository.findByEmailId(emailId);
		if(null!=user && password.equalsIgnoreCase(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
