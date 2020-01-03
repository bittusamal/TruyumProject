package com.cognizant.MenuItem.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.MenuItem.model.Users;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AppUser implements UserDetails{
     
    private Users user; 
    private Collection<? extends GrantedAuthority> authorities; 
    
    public AppUser(){
    	
    }
    
    
     public AppUser(Users user) {
    	 System.out.println("Uma");
    	 	this.user = user;
    	 	
          this.authorities = user.getRoleList()
                                     .stream()
                               .map(role -> new SimpleGrantedAuthority(role.getRole()))
                               .collect(Collectors.toList());
          
          System.out.println("R");
     }

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          
          return this.authorities;
     }

     @Override
     public String getPassword() {
          
          return user.getPassword();
     }

     @Override
     public String getUsername() {
    	 System.out.println(user.getUserName()+" Hello");
          return user.getUserName();
     }

     @Override
     public boolean isAccountNonExpired() {
          
          return true;
     }

     @Override
     public boolean isAccountNonLocked() {
          
          return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
          
          return true;
     }

     @Override
     public boolean isEnabled() {
          
          return true;
     }


	@Override
	public String toString() {
		return "AppUser [user=" + user + ", authorities=" + authorities + "]";
	}
     
     

}
