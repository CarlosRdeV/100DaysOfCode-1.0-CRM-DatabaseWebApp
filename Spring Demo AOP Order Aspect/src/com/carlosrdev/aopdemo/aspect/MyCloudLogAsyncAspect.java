package com.carlosrdev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.carlosrdev.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloadAsync(){
		
		System.out.println("\n=====>>> Logging to Cloud in async fashion");
	}

}
