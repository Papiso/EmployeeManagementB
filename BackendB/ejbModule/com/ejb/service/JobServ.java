package com.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.entities.Job;

/**
 * Session Bean implementation class JobServ
 */
@Stateless
public class JobServ implements JobServRemote {
	
	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;
   
    public JobServ() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void addJob(Job job) {
		entityManager.persist(job);
		
	}

	@Override
	public List<Job> getAllJobs() {
		TypedQuery<Job> query = entityManager.createQuery("SELECT j FROM Job j", Job.class);
		return query.getResultList();
	}

}
