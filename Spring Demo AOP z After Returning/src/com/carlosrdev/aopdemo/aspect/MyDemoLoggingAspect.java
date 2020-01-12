package com.carlosrdev.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	//add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut = "execution(* com.carlosrdev.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
						JoinPoint theJoinPoint, List<Account> result) {
		
		//print out witch method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> Executing @AfterReturning on method: " + method);
		
		//print out the result of the method call
		System.out.println("\n=======> result is: " + result);
		
		//lets post-process the data... lets modify it
		
		//convert the account names to uppercase
		convertAccountNameToUpperCase(result);
		
		//print out the result of the method call
		System.out.println("\n=======> result is: " + result);
		
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
		
		System.out.println("\n=====>>> Executing @Before advice	on AddAccount()");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		
		//display the method arguments
		
		// get args
		Object[] args = theJointPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				//downcast and print account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
				
			}
			
		}
		
	}
	
}
