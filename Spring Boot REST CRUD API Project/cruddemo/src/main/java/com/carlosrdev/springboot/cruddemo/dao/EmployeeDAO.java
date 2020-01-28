package com.carlosrdev.springboot.cruddemo.dao;

import java.util.List;

import com.carlosrdev.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
}
