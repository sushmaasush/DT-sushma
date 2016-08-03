package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.UserDetails;
import com.niit.ColorsBackEnd.model.Users;

public interface UserDao {
	
public List<Users> list();
    
	public Users get(String id);

	public void saveOrUpdate(Users users);

	public void delete(String id);
	
	public void saveOrUpdate(UserDetails userDetails);
	
	public boolean isValidUser(String id, String name, boolean isAdmin);

}
