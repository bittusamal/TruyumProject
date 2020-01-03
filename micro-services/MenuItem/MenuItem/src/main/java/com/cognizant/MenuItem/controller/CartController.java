package com.cognizant.MenuItem.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MenuItem.model.MenuItem;
import com.cognizant.MenuItem.service.CartService;


@RestController
@RequestMapping("/truyum/carts")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@PostMapping("/{userName}/{menuItemId}")
	public boolean addCartItem(@PathVariable String userName, @PathVariable int menuItemId) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return cartService.addCartItem(userName, menuItemId);
	}

	@GetMapping("/{userName}")
	public Set<MenuItem> getAllCartItems(@PathVariable String userName) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return cartService.getAllCartItems(userName);
	}

	@DeleteMapping("/{userName}/{id}")
	public Set<MenuItem> deleteMenuItem(@PathVariable String userName, @PathVariable int id) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return cartService.removeCartItem(userName, id);
	}
	
	
}
