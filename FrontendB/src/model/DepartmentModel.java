package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejb.entities.Department;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name ="departmentModel")
@SessionScoped
public class DepartmentModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Department getEntity() {
		Department department = new Department();
		department.setDepartmentName(departmentName);
		return department;
	}
	
	public DepartmentModel getDepartment( Department  department) {
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setDepartmentName(department.getDepartmentName());
		return departmentModel;
	}
	
	public List<DepartmentModel> getDepartmentList (List<Department> deparmentList){
		List<DepartmentModel> departmentModelList = new ArrayList<>();
		for(Department dept : deparmentList) {
			DepartmentModel departmentModel = new DepartmentModel();
			departmentModel = getDepartment(dept);
			departmentModelList.add(departmentModel);
		}
		return departmentModelList;
	}
}
