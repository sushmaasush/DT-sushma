package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.Supplier;

public interface SupplierDao {
	public List<Supplier> list();
	
	public void saveOrUpdate(Supplier supplier);
	
	public Supplier get(String id);
	
	public void delete(String id);


}
