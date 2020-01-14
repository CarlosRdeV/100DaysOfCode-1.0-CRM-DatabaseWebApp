package com.carlosrdev.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carlosrdev.aopdemo.dao.AccountDAO;
import com.carlosrdev.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {	
	
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
		myLogger.info("\nMain Program: Around Demo App");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);

		myLogger.info("Finished");
		//close context
		context.close();
	}

}
