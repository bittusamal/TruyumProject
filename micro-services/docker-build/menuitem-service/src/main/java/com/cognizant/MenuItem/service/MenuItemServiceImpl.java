package com.cognizant.MenuItem.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MenuItem.model.MenuItem;
import com.cognizant.MenuItem.repository.MenuItemRepository;


@Service
public class MenuItemServiceImpl implements MenuItemService {

	
	@Autowired
	private MenuItemRepository menuItemRepository;

	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.getMenuItemListCustomer();
	}

	@Override
	public MenuItem editMenuItem(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	@Override
	public MenuItem getMenuItem(int id) {
		return menuItemRepository.findById(id).get();
	}
	

}
