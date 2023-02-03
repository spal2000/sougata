package com.sougata.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String depId;
	private String name;
	private String description;
	private boolean status;
	private int totalEmployee;
	private int totalActiveEmployee;
	private int totalDeactiveEmployee;
	private String createdBy;
	private Date creationTime;
	private String modifiedBy;
	private Date modificationTime;
	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
	private List<Employee> employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public int getTotalActiveEmployee() {
		return totalActiveEmployee;
	}
	public void setTotalActiveEmployee(int totalActiveEmployee) {
		this.totalActiveEmployee = totalActiveEmployee;
	}
	public int getTotalDeactiveEmployee() {
		return totalDeactiveEmployee;
	}
	public void setTotalDeactiveEmployee(int totalDeactiveEmployee) {
		this.totalDeactiveEmployee = totalDeactiveEmployee;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public Department(int id, String depId, String name, String description, boolean status, int totalEmployee,
			int totalActiveEmployee, int totalDeactiveEmployee, String createdBy, Date creationTime, String modifiedBy,
			Date modificationTime, List<Employee> employee) {
		super();
		this.id = id;
		this.depId = depId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.totalEmployee = totalEmployee;
		this.totalActiveEmployee = totalActiveEmployee;
		this.totalDeactiveEmployee = totalDeactiveEmployee;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.modifiedBy = modifiedBy;
		this.modificationTime = modificationTime;
		this.employee = employee;
	}
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
