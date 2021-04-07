package com.ejb.service;

import java.util.List;

import javax.ejb.Remote;

import com.ejb.entities.Employee;

@Remote
public interface EmployeeServRemote {
	
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
}
