package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

import com.ejb.service.DepartmentServRemote;

import model.DepartmentModel;

@ManagedBean(value = "departmentController")
@SessionScoped
public class DepartmentController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	 private DepartmentServRemote deptservice;
	 
	 @ManagedProperty(value="#{departmentModel}")
	 private DepartmentModel departmentModel;
	 
	 private List<DepartmentModel> departments = new ArrayList<>();
	 
	 public DepartmentModel getDepartmentModel() {
		return departmentModel;
	}

	public void setDepartmentModel(DepartmentModel departmentModel) {
		this.departmentModel = departmentModel;
	}

	 public List<DepartmentModel> getDepartments(){
		 departments = departmentModel.getDepartmentList(deptservice.getAllDepartments());
		 return departments;
	 }
	 
	 public String addNewDepartment() {
		 deptservice.addDepartment(departmentModel.getEntity());
		 return "addDepartment.xhtml";
	 }
	 
	 public String viewDepartment(){
	        return "allDepartments.xhtml";
	    }
}
