package com.cognizant.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.UserAlreadyExistException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUserDetailsService;
import com.cognizant.truyum.service.UserService;


@ContextConfiguration(classes=TruyumApplication.class)
@SpringBootTest
public class UserDetailsServiceMockTest {
       
       
      
       
       @Autowired
       UserService userService;
       
       @Autowired
   	   PasswordEncoder encoder;
       
       @MockBean
   	   UserRepository userRepository;
	       
	    @Test
	   	void contextLoads() {
	   	}
	    
	   	public Users newUser() {
	   		LOGGER.info("Start");
	   		Users user = new Users(0,"user",encoder.encode("pwd"),"user","user",null,null);
	   		LOGGER.info("End");
	   		return user;
	   	}
       
       private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
       
       public Users createUser(){
   		LOGGER.info("Start");
   		Set<MenuItem> movieList = new HashSet<MenuItem>();
   		Set<Role> roleList = new HashSet<Role>();
   		roleList.add(new Role(2,"user"));
   		Users user = new Users(0,"user",encoder.encode("pwd"),"user","user",roleList,movieList);
   		LOGGER.info("End");
   		return user;
   	}
   	
   	@Test
   	public void userDetailsSignUpTestException() {
   		LOGGER.info("Start");
   		when(userRepository.findByUserName("user")).thenReturn(createUser());
   		assertThrows(UserAlreadyExistException.class, () -> 
   		userService.signUp(createUser()));
   		LOGGER.info("End");
   	}
   	
   	@Test
   	public void userDetailsSignUpTest() {
   		LOGGER.info("Start");
   		when(userRepository.findByUserName(newUser().getUserName())).thenReturn(null);
   		assertDoesNotThrow( () -> userService.signUp(createUser()));
   		LOGGER.info("End");
   	}
   	
   }  