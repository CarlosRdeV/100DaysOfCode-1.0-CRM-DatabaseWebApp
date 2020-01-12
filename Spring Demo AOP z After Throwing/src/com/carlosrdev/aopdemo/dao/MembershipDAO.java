package com.carlosrdev.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": IM GOING TO SLEEP NOW...");
		
	}
}
