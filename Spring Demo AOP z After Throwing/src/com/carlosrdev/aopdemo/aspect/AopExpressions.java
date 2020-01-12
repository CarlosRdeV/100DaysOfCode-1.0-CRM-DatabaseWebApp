package com.carlosrdev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create a pointcut for getter methods
	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create a pointcut for setter methods
	@Pointcut("execution(* com.carlosrdev.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// creat pointcut: include package ... exclude getter/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
