package com.carlosrdev.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlosrdev.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		System.out.println("\nlets calling again!<\n");
		
		theAccountDAO.addAccount();
		
		//close context
		context.close();
	}

}
