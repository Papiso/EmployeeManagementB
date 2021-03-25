package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

import com.ejb.service.JobService;

import model.JobModel;

@ManagedBean(value = "jobController")
@SessionScoped
public class JobController {
	
	@EJB
	private JobService jobService;
	
	@ManagedProperty(value="#{jobModel}")
	private JobModel jobModel;
	
	private List<JobModel> jobs = new ArrayList<>(); 

	public JobModel getJobModel() {
		return jobModel;
	}

	public void setJobModel(JobModel jobModel) {
		this.jobModel = jobModel;
	}
	
	public List<JobModel> getJobs(){
		jobs = jobModel.getJobList(jobService.getAllJobs());
		return jobs;
	}
	
	public String addNewJob() {
		jobService.addJob(jobModel.getEntity());
		 return "addJob.xhtml";
	 }
	
	
}
