package com.cognizant.TruyumSignUp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="us_id")
	private int id;
	
	@NotNull
	@Size(min = 2, max = 10, message = "Name should be min 2 max 10 characters")
	@Column(name="us_userName")
	private String userName;
	
	@Column(name="us_password")
	private String password;
	
	@Column(name="us_firstName")
	private String firstName;
	
	@Column(name="us_lastName")
	private String lastName;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart",
        joinColumns = @JoinColumn(name = "ct_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<MenuItem> menuItemList;

	public Users(){
		
	}
	

	public Users(int id,String userName,String password,String firstName, String lastName, Set<Role> roleList, Set<MenuItem> menuItemList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleList = roleList;
		this.menuItemList = menuItemList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		System.out.println("hai");
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", roleList=" + roleList + ", menuItemList=" + menuItemList + "]";
	}
	
	
	
	
	
	
	

	

}
