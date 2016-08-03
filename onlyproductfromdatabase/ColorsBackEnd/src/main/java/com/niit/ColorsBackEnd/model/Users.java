package com.niit.ColorsBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="USER")
@Component
public class Users {
	
	@Id
	private String user_ID;
	private String user_Name;
	private String password;
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
