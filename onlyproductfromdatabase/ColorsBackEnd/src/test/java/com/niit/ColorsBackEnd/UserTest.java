package com.niit.ColorsBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ColorsBackEnd.dao.UserDao;
import com.niit.ColorsBackEnd.model.Users;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ColorsBackEnd");
		context.refresh();
		
		UserDao user=(UserDao) context.getBean("userDao");
		System.out.println(user.list().size());
		Users u=(Users) context.getBean("users");
		
		
	}

}
