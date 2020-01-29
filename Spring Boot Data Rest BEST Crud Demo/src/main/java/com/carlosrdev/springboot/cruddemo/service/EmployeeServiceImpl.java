package com.carlosrdev.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosrdev.springboot.cruddemo.dao.EmployeeRepository;
import com.carlosrdev.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository thEmployeeRepository) {
		employeeRepository = thEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {

			theEmployee = result.get();

		}else {
			// we didnt find the employee
			
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;

	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {
		employeeRepository.deleteById(theId);
	}

}
