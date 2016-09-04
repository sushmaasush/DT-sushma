package com.niit.ColorsBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ColorsBackEnd.dao.CartDao;
import com.niit.ColorsBackEnd.dao.UserDao;
import com.niit.ColorsBackEnd.model.Cart;
import com.niit.ColorsBackEnd.model.Users;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ColorsBackEnd");
		context.refresh();
//		UserDao userDao=(UserDao) context.getBean("userDao");
//		Users user=(Users) context.getBean("users");
//		System.out.println("hello");
//		user.setUser_id("nmit");
//		user.setPassword("nmit");
//		user.setUrole("admin");
//		
//		userDao.saveOrUpdate(user);
		/*user=userDao.getValidate("nmit");
		System.out.println(user.getUrole());
		System.out.println(userDao.list().size());*/
		
		CartDao cartDao=(CartDao) context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");
		List<Cart> item = cartDao.getAll("user");
		System.out.println(item);
	}

}
