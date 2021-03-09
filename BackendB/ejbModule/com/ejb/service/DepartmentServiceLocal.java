package com.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.ejb.entities.Department;

@Local
public interface DepartmentServiceLocal {
	public void addDepartment(Department department);
	public List<Department> getAllDepartments();
}
