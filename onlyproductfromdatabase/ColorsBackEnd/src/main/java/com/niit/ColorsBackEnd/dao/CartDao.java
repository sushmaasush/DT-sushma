package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.Cart;

public interface CartDao {

	public void SaveOrUpdate(Cart cart);
	
	public List<Cart> list();
	
	public List<Cart> getAll(String usr);
	
	public void delete(String id,String pname);

	public void delete(String id);
	
	public Cart getCart(String id);

}
