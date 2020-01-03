package com.cognizant.MenuItem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.MenuItem.model.MenuItem;


@Service
public interface MenuItemService {
	public List<MenuItem> getMenuItemListCustomer();

	public List<MenuItem> getMenuItemListAdmin();

	public MenuItem editMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(int id);
}
