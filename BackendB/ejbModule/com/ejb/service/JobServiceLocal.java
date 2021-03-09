package com.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.ejb.entities.Job;

@Local
public interface JobServiceLocal {
	public void addJob(Job job);
	public List<Job> getAllJobs();
}
