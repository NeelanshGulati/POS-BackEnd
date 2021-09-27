package com.nagarro.service;

import java.util.List;

import com.nagarro.model.User;
import com.nagarro.repository.UserRepository;

public class UserService {
	UserRepository userRepository = new UserRepository();

	public User authenticateUser(String name, String password) {
		User user = userRepository.getUser(name);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}

		System.out.println("User found =>" + user);
		return null;
	}
	
	public List<User> getAllUsers() {
		List<User> userList = userRepository.getUsers();

		if (userList == null) {
			System.err.println("Empty List found!");
		}
		return userList;
	}
}
