package com.cognizant.truyum.service;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Users;



@Service
public interface UserService {

	Users getAllUser(int id);
	public void signUp(Users userDetails);
}
