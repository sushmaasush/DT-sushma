package com.niit.ColorsBackEnd.dao;

import java.util.List;

import com.niit.ColorsBackEnd.model.Shipping;
import com.niit.ColorsBackEnd.model.Supplier;

public interface ShippingDao {
    
	public void saveOrUpdateOrdres(Shipping shipping);

	public void delete(String id);
	
	public List<Shipping> list();
	
	public Shipping get(String id);

}
