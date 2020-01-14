package com.carlosrdev.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlosrdev.aopdemo.dao.AccountDAO;
import com.carlosrdev.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {	

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
		System.out.println("\nMain Program: Around Demo App");
		
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
		//close context
		context.close();
	}

}
