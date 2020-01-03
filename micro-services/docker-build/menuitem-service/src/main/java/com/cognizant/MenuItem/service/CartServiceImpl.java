package com.cognizant.MenuItem.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MenuItem.exception.CartEmptyException;
import com.cognizant.MenuItem.model.MenuItem;
import com.cognizant.MenuItem.model.Users;
import com.cognizant.MenuItem.repository.MenuItemRepository;
import com.cognizant.MenuItem.repository.UserRepository;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Override
	public boolean addCartItem(String userName, int menuItem) {
		
		Users user = userRepository.findByUserName(userName);
		Set<MenuItem> menuItemList = new HashSet<MenuItem>();
		menuItemList = user.getMenuItemList();
		MenuItem oneMenuItem = menuItemRepository.findById(menuItem).get();
		menuItemList.add(oneMenuItem);
		user.setMenuItemList(menuItemList);
		userRepository.save(user);
		return true;
	}

	@Override
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException {
		
		Users user = userRepository.findByUserName(userName);
		
		if(user.getMenuItemList().isEmpty()) {
			throw new CartEmptyException("true");
		}else {
			return user.getMenuItemList();
		}
		
		
	}

	@Override
	public Set<MenuItem> removeCartItem(String userName, int menuItemId) {
		
		Users user = userRepository.findByUserName(userName);
		
		Set<MenuItem> menuItemList = new HashSet<MenuItem>();
		menuItemList = user.getMenuItemList();
		boolean flag = false;
		for(MenuItem itr: menuItemList) {
			if(itr.getId() == menuItemId) {
				flag = menuItemList.remove(itr);
				break;
			}
		}
		if(flag) {
		user.setMenuItemList(menuItemList);
		
		userRepository.save(user);
		}
		
		return menuItemList;
	}
}
