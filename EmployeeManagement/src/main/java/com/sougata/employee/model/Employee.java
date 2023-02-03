package com.sougata.employee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeId;
	private int age;
	private String name;
	@ManyToOne
	private Department department;
	private long mobileNumber;
	private long aadharNumber;
	private String address;
	private String email;
	private String gender;
	private boolean status;
	private String createdBy;
	private Date creationTime;
	private String modifiedBy;
	private Date modificationTime;
	private byte[] employeePhoto;
	private byte[]policeVerificationPhoto;
	private byte[]employeeAadharPhoto;
	private String remark;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public byte[] getEmployeePhoto() {
		return employeePhoto;
	}
	public void setEmployeePhoto(byte[] employeePhoto) {
		this.employeePhoto = employeePhoto;
	}
	public byte[] getPoliceVerificationPhoto() {
		return policeVerificationPhoto;
	}
	public void setPoliceVerificationPhoto(byte[] policeVerificationPhoto) {
		this.policeVerificationPhoto = policeVerificationPhoto;
	}
	public byte[] getEmployeeAadharPhoto() {
		return employeeAadharPhoto;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setEmployeeAadharPhoto(byte[] employeeAadharPhoto) {
		this.employeeAadharPhoto = employeeAadharPhoto;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String employeeId, int age, String name, Department department, long mobileNumber,
			long aadharNumber, String address, String email, String gender, boolean status, String createdBy,
			Date creationTime, String modifiedBy, Date modificationTime, byte[] employeePhoto,
			byte[] policeVerificationPhoto, byte[] employeeAadharPhoto, String remark) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.age = age;
		this.name = name;
		this.department = department;
		this.mobileNumber = mobileNumber;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.modifiedBy = modifiedBy;
		this.modificationTime = modificationTime;
		this.employeePhoto = employeePhoto;
		this.policeVerificationPhoto = policeVerificationPhoto;
		this.employeeAadharPhoto = employeeAadharPhoto;
		this.remark = remark;
	}
	
	
}
	
	