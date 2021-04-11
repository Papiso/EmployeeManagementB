package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ejb.service.JobServRemote;

import model.JobModel;

@ManagedBean(name = "jobController")
@SessionScoped
public class JobController implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@EJB
	private JobServRemote jobService;
	
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
