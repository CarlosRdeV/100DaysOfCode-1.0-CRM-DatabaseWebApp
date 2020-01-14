	package com.carlosrdev.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.carlosrdev.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.carlosrdev.aopdemo.service.*.getFortune(..))")	
	public Object aroundGetFortuneAdvise(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======> Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// NOW, LETS EXECUTE THE METHOD
		Object result = theProceedingJoinPoint.proceed();
		
		// get end timeslap
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		
		myLogger.info("\n\n=======> Duration: " + duration / 1000 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.carlosrdev.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinnalyAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out witch method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======> Executing @After (finally) on method: " + method);
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.carlosrdev.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
						JoinPoint theJoinPoint, Throwable theExc) {
	
		//print out witch method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======> Executing @AfterThrowing on method: " + method);
		
		//log the exception
		myLogger.info("\n=======> The exception is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.carlosrdev.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
						JoinPoint theJoinPoint, List<Account> result) {
		
		//print out witch method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======> Executing @AfterReturning on method: " + method);
		
		//print out the result of the method call
		myLogger.info("\n=======> result is: " + result);
		
		//lets post-process the data... lets modify it
		
		//convert the account names to uppercase
		convertAccountNameToUpperCase(result);
		
		//print out the result of the method call
		myLogger.info("\n=======> result is: " + result);
		
	}
	
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		
		//loop through accounts
		for (Account tempAccount : result ) {
			
			//get uppercase version name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//update name on the account	
			tempAccount.setName(theUpperName);
		}	
	}




	@Before("com.carlosrdev.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint theJointPoint){
		
		myLogger.info("\n=====>>> Executing @Before advice	on AddAccount()");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		
		//display the method arguments
		
		// get args
		Object[] args = theJointPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				//downcast and print account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
				
			}
			
		}
		
	}
	
}
