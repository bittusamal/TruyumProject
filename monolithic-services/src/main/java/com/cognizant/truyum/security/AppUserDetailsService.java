package com.cognizant.truyum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{


	       @Autowired
	       UserRepository userRepository;
	       
	       public AppUserDetailsService(UserRepository userRepository){
	    	   this.userRepository = userRepository;
	       }
	       
	       @Override
	       public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
	       Users user = userRepository.findByUserName(name);
	       UserDetails appUser = null;
	              if(user == null) {
	                     throw new UsernameNotFoundException("User Not Found");
	              }
	              else {
	                     System.out.println("else");
	                     appUser = new AppUser(user);
	                     
	              }
	              return appUser;
	       }
	}

