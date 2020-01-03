package com.cognizant.MenuItem.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.MenuItem.exception.CartEmptyException;
import com.cognizant.MenuItem.model.MenuItem;


@Service
public interface CartService {

	public boolean addCartItem(String userName, int menuItem);
	
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException;
	
	public Set<MenuItem> removeCartItem(String userName, int menuItemId);

}
