package com.niit.ColorsBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Shippingtest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		
	}

}
