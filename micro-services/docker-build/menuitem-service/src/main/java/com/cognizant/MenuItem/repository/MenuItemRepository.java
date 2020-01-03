package com.cognizant.MenuItem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.MenuItem.model.MenuItem;


public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{

	@Query(nativeQuery = true , value="select me_id,me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery, me_image_url\r\n" + 
			"    from truyum.menu_item \r\n" + 
			"    where me_date_of_launch = NOW() \r\n" + 
			"    or me_date_of_launch < NOW() \r\n" + 
			"    and me_active = 'Yes'")
	List<MenuItem> getMenuItemListCustomer();
}
