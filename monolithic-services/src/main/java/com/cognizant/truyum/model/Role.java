package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ro_id")
	private int id;
	
	@Column(name="ro_name")
	private String name;
	
	public Role() {
		
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.name = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return name;
	}

	public void setRole(String role) {
		this.name = role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + name + "]";
	}
	
	
}
