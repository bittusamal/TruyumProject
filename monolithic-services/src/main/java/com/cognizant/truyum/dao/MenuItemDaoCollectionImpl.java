package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
//
//	private static List<MenuItem> menuItemList;
//
//	public MenuItemDaoCollectionImpl() {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
//		menuItemList = (ArrayList) context.getBean("menuItemList");
//
//	}
//
//	@Override
//	public MenuItem getMenuItem(long menuItemId) {
//
//		LOGGER.info("Start");
//
//		MenuItem item = null;
//		for (int i = 0; i < menuItemList.size(); i++) {
//			if (menuItemId == menuItemList.get(i).getId()) {
//				item = menuItemList.get(i);
//				break;
//			}
//		}
//		LOGGER.info("End");
//		return item;
//	}
//
//	@Override
//	public List<MenuItem> getMenuItemListCustomer() {
//
//		LOGGER.info("Start");
//
//		List<MenuItem> customerList = new ArrayList<MenuItem>();
//		for (MenuItem item : menuItemList) {
//			int dateComapare = item.getDateOfLaunch().compareTo(new Date());
//			if (item.isActive() == true && (dateComapare == 0 || dateComapare < 0)) {
//				customerList.add(item);
//			}
//		}
//		LOGGER.info("End");
//		return customerList;
//
//	}
//
//	@Override
//	public boolean editMenuItem(MenuItem item) {
//		LOGGER.info("Start");
//		for (int i = 0; i < menuItemList.size(); i++) {
//			if (item.getId() == menuItemList.get(i).getId()) {
//				menuItemList.set(i, item);
//				break;
//			}
//		}
//		LOGGER.info("End");
//		return true;
//	}
//
//	@Override
//	public List<MenuItem> getMenuItemListAdmin() {
//		LOGGER.info("Start");
//		LOGGER.info("End");
//		return menuItemList;
//	}
}
