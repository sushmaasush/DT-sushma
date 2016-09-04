package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.Users;

public interface UserDao {
	
public List<Users> list();
    
	public void saveOrUpdateUsers(Users users);

	public void delete(String id);
	
	public boolean isValidUser(String id, String pwd);
	
	Users getValidate(String s1);

}
