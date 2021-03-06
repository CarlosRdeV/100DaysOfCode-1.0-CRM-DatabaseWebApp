package com.carlosrdev.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlosrdev.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {	

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

		List<Account> theAccounts = null;
		
		//call method to find the accounts
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);	
		} 
		catch (Exception exc) {
			System.out.println("\n\nMain Program ... caugh exception: " + exc );
		}
			
		//display the accounts
		System.out.println("\n\nMain Program: Afterthrowing Demo App");
		System.out.println("--------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
	
		//close context
		context.close();
	}

}
