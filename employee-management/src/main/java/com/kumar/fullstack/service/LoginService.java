package com.kumar.fullstack.service;

import com.kumar.fullstack.model.User;

public interface LoginService {

	public User login(String emailId,String password);
	public User createUser(User user);
}
