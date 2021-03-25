package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejb.entities.Job;

@ManagedBean(name = "jobModel")
@SessionScoped
public class JobModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String title;
	private double salary;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Job getEntity() {
		Job job = new Job();
		job.setTitle(title);
		job.setSalary(salary);
		return job;
	}
	
	public JobModel getJob( Job  job) {
		JobModel jobModel = new JobModel();
		jobModel.setTitle(job.getTitle());
		jobModel.setSalary(job.getSalary());
		return jobModel;
	}
	
	public List<JobModel> getJobList (List<Job> jobList){
		List<JobModel> jobModelList = new ArrayList<>();
		for(Job jb : jobList) {
			JobModel jobModel = new JobModel();
			jobModel = getJob(jb);
			jobModelList.add(jobModel);
		}
		return jobModelList;
	}

}
