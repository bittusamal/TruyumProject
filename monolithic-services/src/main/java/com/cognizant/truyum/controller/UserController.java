package com.cognizant.truyum.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.service.UserService;

@RestController
@RequestMapping("/truyum")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public Users getAllUser(@PathVariable int id){
		return userService.getAllUser(id);
	}
	
	@PostMapping("/users")
	public void signUp(@RequestBody @Valid Users userDetails) {
		LOGGER.info("Start");
		userService.signUp(userDetails);
	}
	
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}
	

}
