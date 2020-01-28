package com.carlosrdev.springboot.cruddemo.service;

import java.util.List;

import com.carlosrdev.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void delete(int theId);

}
