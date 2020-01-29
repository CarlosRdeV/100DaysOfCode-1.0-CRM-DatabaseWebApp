package com.carlosrdev.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosrdev.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
