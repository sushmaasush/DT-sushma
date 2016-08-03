package com.niit.ColorsBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ColorsBackEnd.dao.CategoryDao;
import com.niit.ColorsBackEnd.dao.SupplierDao;
import com.niit.ColorsBackEnd.model.Category;


public class CatTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		CategoryDao cat=(CategoryDao) context.getBean("categoryDao");
		
			System.out.println(cat.list().size());
		
	}
	
}
