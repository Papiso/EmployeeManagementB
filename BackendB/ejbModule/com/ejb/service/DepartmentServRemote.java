package com.ejb.service;

import java.util.List;

import javax.ejb.Remote;

import com.ejb.entities.Department;

@Remote
public interface DepartmentServRemote {
	
	public void addDepartment(Department department);
	public List<Department> getAllDepartments();
}
