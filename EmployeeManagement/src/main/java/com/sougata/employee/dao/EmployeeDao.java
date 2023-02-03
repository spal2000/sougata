package com.sougata.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sougata.employee.model.Employee;

@Component
@Repository
public class EmployeeDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create
	@Transactional
	public void createEmployee(Employee employee) 
	{
		this.hibernateTemplate.save(employee);
		
	}
	@Transactional
	public void updateEmployee(Employee employee) {
		this.hibernateTemplate.update(employee);
	}
	
	//get all employee
	public List<Employee> getemployees(){
		
		List<Employee> employees=this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}
	
	//delete the single employee
	@Transactional
	public void deleteEmployee(int id) {
		
		Employee e = this.hibernateTemplate.load(Employee.class, id);
		this.hibernateTemplate.delete(e);
	}
	
	//get the single employee
	public Employee getEmployee(int id) {
		
		return this.hibernateTemplate.get(Employee.class , id);
		
	}

}
