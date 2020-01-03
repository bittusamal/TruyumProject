package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
//
//	private static Map<String, Cart> userCarts;
//
//	public CartDaoCollectionImpl() {
//		if (userCarts == null) {
//			userCarts = new HashMap<String, Cart>();
//		}
//	}
//
//	@Override
//	public boolean addCartItem(String userName, long menuItem) {
//
//		LOGGER.info("Start");
//
//		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//		MenuItem item = menuItemDao.getMenuItem(menuItem);
//
//		if (userCarts.containsKey(userName)) {
//
//			Cart cartItem = userCarts.get(userName);
//			cartItem.getMenuItemList().add(item);
//
//		} else {
//
//			Cart cartItem = new Cart(new ArrayList<MenuItem>(), 0.00);
//			cartItem.getMenuItemList().add(item);
//			userCarts.put(userName, cartItem);
//		}
//		LOGGER.info("End");
//		return true;
//	}
//
//	@Override
//	public List<MenuItem> getAllCartItems(String userName) throws CartEmptyException {
//
//		LOGGER.info("Start");
//
//		if (userCarts.isEmpty()) {
//
//			LOGGER.info("End");
//			throw new CartEmptyException("true");
//
//		} else {
//
//			Cart cart = userCarts.get(userName);
//			List<MenuItem> menuItem = cart.getMenuItemList();
//
//			if (menuItem.isEmpty()) {
//
//				throw new CartEmptyException("true");
//
//			} else {
//
//				double total = 0.0;
//				for (MenuItem item : menuItem) {
//					total = total + item.getPrice();
//				}
//
//				cart.setTotal(total);
//			}
//
//			LOGGER.info("End");
//			return menuItem;
//		}
//
//	}
//
//	@Override
//	public List<MenuItem> removeCartItem(String userName, long menuItemId) {
//
//		LOGGER.info("Start");
//
//		List<MenuItem> menuItem = null;
//		if (userCarts.containsKey(userName)) {
//
//			Cart cart = userCarts.get(userName);
//			menuItem = cart.getMenuItemList();
//
//			for (int i = 0; i < menuItem.size(); i++) {
//				if (menuItem.get(i).getId() == menuItemId) {
//
//					menuItem.remove(i);
//				}
//			}
//		}
//		LOGGER.info("End");
//
//		return menuItem;
}
