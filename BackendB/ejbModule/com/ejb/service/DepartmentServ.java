package com.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.entities.Department;

/**
 * Session Bean implementation class DepartmentServ
 */
@Stateless
public class DepartmentServ implements DepartmentServRemote {

	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;

    public DepartmentServ() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void addDepartment(Department department) {
		entityManager.persist(department);
		
	}

	@Override
	public List<Department> getAllDepartments() {
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d", Department.class);
		return query.getResultList();
	}

}
