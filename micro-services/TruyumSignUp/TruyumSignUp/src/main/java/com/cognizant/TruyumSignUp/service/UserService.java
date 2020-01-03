package com.cognizant.TruyumSignUp.service;

import org.springframework.stereotype.Service;

import com.cognizant.TruyumSignUp.model.Users;


@Service
public interface UserService {

	Users getAllUser(int id);
	public void signUp(Users userDetails);
}
