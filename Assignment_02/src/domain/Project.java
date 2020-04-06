package domain;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private Integer project_Id;
	private String title;
	
	//projects有多个employee参与
	Set<Employee> employees = new HashSet<>();

	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Integer getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(Integer project_Id) {
		this.project_Id = project_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Project [project_Id=" + project_Id + ", title=" + title + "]";
	}
}
