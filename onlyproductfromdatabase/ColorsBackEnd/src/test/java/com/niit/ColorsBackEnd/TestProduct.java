package com.niit.ColorsBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.model.Product;


public class TestProduct {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		Product c =(Product)	  context.getBean("product");
		
		ProductDao productDAO = (ProductDao)  context.getBean("productDao");
		
		List<Product>  list =    productDAO.list();
		
		/*for(Product cat : list)
		{
			System.out.println(cat.getPid()  + ":" +  cat.getPname() + ":" +  cat.getPprice() + ":" + cat.getPdes());
		}*/
			
	    /*c.setPid("102");
	    c.setPname("Shot");
	    c.setPcat("fragrance");
	    c.setPprice(100);
	    c.setPstock(1);
	    c.setPdes("Fragrance");
	    
	    productDAO.getPro("101");
	 
	    productDAO.saveOrUpdate(c);*/
	    
	    
	    for(Product cat : list)
		{
			System.out.println(cat.getPid()  + ":" +  cat.getPname() + ":" +  cat.getPprice() + ":" + cat.getPdes());
		}
		
		/*productDAO.delete("102");
		for(Product cat : list)
		{
			System.out.println(cat.getPid()  + ":" +  cat.getPname() + ":" +  cat.getPprice() + ":" + cat.getPdes());
		}*/
	}

}
