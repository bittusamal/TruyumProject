package com.cognizant.truyum.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public interface CartService {

	public boolean addCartItem(String userName, int menuItem);
	
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException;
	
	public Set<MenuItem> removeCartItem(String userName, int menuItemId);

}
