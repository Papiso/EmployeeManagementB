package com.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.entities.Job;


@Stateless
public class JobService implements JobServiceLocal {
	
	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;
    
    public JobService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addJob(Job job) {
		entityManager.persist(job);
		
	}

	@Override
	public List<Job> getAllJobs() {
		TypedQuery<Job> query = entityManager.createQuery("SELECT j Job Department j", Job.class);
		return query.getResultList();
	}

}
