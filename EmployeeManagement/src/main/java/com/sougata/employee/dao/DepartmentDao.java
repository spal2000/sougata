package com.sougata.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sougata.employee.model.Department;

@Component
public class DepartmentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createDepartment(Department department) {
		this.hibernateTemplate.save(department);

	}
	@Transactional
	public void updateDepartment(Department department) {
		this.hibernateTemplate.update(department);

	}
	
	
	public List<Department> getDepartments() {

		List<Department> departments = this.hibernateTemplate.loadAll(Department.class);
		return departments;
	}
	
	public Department getDepartment(int id) {

		return this.hibernateTemplate.get(Department.class, id);

	}

	

}
