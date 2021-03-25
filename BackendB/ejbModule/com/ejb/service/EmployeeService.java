package com.ejb.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.entities.Employee;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceLocal {

	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;
   
	
    public EmployeeService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

}
