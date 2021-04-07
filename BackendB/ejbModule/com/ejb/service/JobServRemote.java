package com.ejb.service;

import java.util.List;

import javax.ejb.Remote;

import com.ejb.entities.Job;

@Remote
public interface JobServRemote {
	
	public void addJob(Job job);
	public List<Job> getAllJobs();
}
