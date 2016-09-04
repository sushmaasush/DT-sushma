package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.Category;
import com.niit.ColorsBackEnd.model.Product;

public interface CategoryDao {

	public List<Category> list();
	
	public Category get(String id);

	public void saveOrUpdate(Category category);

	public void delete(int id);

}
