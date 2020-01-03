package com.cognizant.TruyumSignUp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.TruyumSignUp.exception.UserAlreadyExistException;
import com.cognizant.TruyumSignUp.model.Role;
import com.cognizant.TruyumSignUp.model.Users;
import com.cognizant.TruyumSignUp.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    PasswordEncoder encoder;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public Users getAllUser(int id) {
		
		return userRepository.findById(id).get();
	}
	
	@Override
	public void signUp(@RequestBody @Valid Users userDetails) {
		LOGGER.info("Start");
		Users user = userRepository.findByUserName(userDetails.getFirstName());
		if (user !=null) {
			LOGGER.info("End");
			throw new UserAlreadyExistException("User Already Exist");
		} else {
			
			String encodedPassword = encoder.encode(userDetails.getPassword());
            Set<Role> roleList = new HashSet();
            roleList.add(new Role(2,"user"));
            userDetails = new Users(0,userDetails.getUserName(), encodedPassword,userDetails.getFirstName(), userDetails.getLastName(), roleList, null);
			userRepository.save(userDetails);
			LOGGER.info("End");
		}
	}
	

}
