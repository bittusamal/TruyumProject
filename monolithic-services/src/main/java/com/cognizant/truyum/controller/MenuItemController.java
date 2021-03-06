package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUser;
import com.cognizant.truyum.security.AppUserDetailsService;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/truyum")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Autowired
	MenuItemService menuItemService;

	@Autowired
    UserRepository userRepository;
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	AppUser appUser;
	
	@GetMapping("/menu-items")
	public List<MenuItem> getAllMenuItem() {

		LOGGER.info("Start");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		if (user != "anonymousUser") {
			
			UserDetails userDetailss = appUserDetailsService.loadUserByUsername(authentication.getName());
			String role = userDetailss.getAuthorities().toArray()[0].toString();

			 System.out.println(role);

			if (role.equals("ADMIN")) {
				LOGGER.info("End");
				return menuItemService.getMenuItemListAdmin();
			} else {
				LOGGER.info("End");
				return menuItemService.getMenuItemListCustomer();
			}
		} else {
			LOGGER.info("End");
			return menuItemService.getMenuItemListCustomer();
		}

	}

	
	@GetMapping("/menu-items/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemService.getMenuItem(id);
	}

	
	@PutMapping("/menu-items")
	public MenuItem modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemService.editMenuItem(menuItem);
	}
}
