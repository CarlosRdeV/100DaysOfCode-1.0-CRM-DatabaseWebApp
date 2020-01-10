package com.carlosrdev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//lets start with an @Before advice

	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create a pointcut for getter methods
	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create a pointcut for setter methods
	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// creat pointcut: include package ... exclude getter/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(){
		
		System.out.println("\n=====>>> Executing @Before advice	on AddAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics(){
		
		System.out.println("\n=====>>> Performing API analytics");
	}
	
}
