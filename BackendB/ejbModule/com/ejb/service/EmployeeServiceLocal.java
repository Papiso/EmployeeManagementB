package com.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.ejb.entities.Employee;

@Local
public interface EmployeeServiceLocal {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
}
