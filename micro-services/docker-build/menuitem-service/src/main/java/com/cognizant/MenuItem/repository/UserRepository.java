package com.cognizant.MenuItem.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.MenuItem.model.MenuItem;
import com.cognizant.MenuItem.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUserName(String userName);
	
	@Query(nativeQuery = true , value="select * from truyum.menu_item inner join truyum.cart on me_id = ct_pr_id where ct_us_id = ?1")
	Set<MenuItem> getMenuItemList(int id);
	
}
