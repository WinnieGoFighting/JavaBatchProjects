package domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class Employee {
	private Integer employee_Id;
	private String name;
	private String email;
	private Integer age;
	
	private Set<Project> projects = new HashSet<>();
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Integer getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(Integer employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
