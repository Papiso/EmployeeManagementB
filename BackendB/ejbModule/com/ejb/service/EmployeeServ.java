package com.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.entities.Employee;

/**
 * Session Bean implementation class EmployeeServ
 */
@Stateless
public class EmployeeServ implements EmployeeServRemote {

	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;
	
    public EmployeeServ() {
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
