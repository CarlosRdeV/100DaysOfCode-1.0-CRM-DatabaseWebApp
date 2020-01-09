package com.carlosrdev.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlosrdev.aopdemo.dao.AccountDAO;
import com.carlosrdev.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		//call the membership bussiness method
		theMembershipDAO.addAccount();
		
		//close context
		context.close();
	}

}
