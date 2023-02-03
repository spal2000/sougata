package com.sougata.employee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sougata.employee.dao.DepartmentDao;
import com.sougata.employee.dao.EmployeeDao;
import com.sougata.employee.dao.UserDao;
import com.sougata.employee.model.Department;
import com.sougata.employee.model.Employee;
import com.sougata.employee.model.User;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	UserDao userDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	UserController userController;

	@RequestMapping("/addDepartment")
	public String viewAddDepartment(Model model) {
		System.out.println("dep ok");
		model.addAttribute("title", "Add Department");
		return "addDepartment";
	}

	@RequestMapping(path = "/add_department", method = RequestMethod.POST)
	public String addDepartment(@RequestParam("depId") String depId, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {
		Department department = new Department();

		department.setDepId(depId);
		department.setName(name);
		department.setDescription(description);
		department.setStatus(true);
		department.setCreatedBy(userController.username1);
		department.setCreationTime(new Date());
		departmentDao.createDepartment(department);

		List<Department> departments = departmentDao.getDepartments();
		model.addAttribute("department", departments);

		return "department_table";
	}

	@RequestMapping(path = "/update_department", method = RequestMethod.POST)
	public String updateDepartment(@RequestParam("id") int id,
			@RequestParam(name = "depId", required = true) String depId, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {
		Department department = departmentDao.getDepartment(id);
		department.setDepId(depId);
		department.setName(name);
		
		department.setDescription(description);
		department.setStatus(true);
		department.setModifiedBy(userController.username1);
		department.setModificationTime(new Date());
		departmentDao.updateDepartment(department);

		List<Department> departments = this.departmentDao.getDepartments();
		model.addAttribute("department", departments);

		return "department_table";
	}

	@RequestMapping("/update_department_status")
	public String updateDepartmentStatus(@RequestParam("id") int id, @RequestParam("status") boolean status,
			Model model) {
		Department department = departmentDao.getDepartment(id);
		if (department.isStatus() == true) {
			department.setStatus(false);
			System.out.println(department.getTotalEmployee());
			department.setTotalEmployee(0);
			System.out.println("============================department============================");
			department.setTotalActiveEmployee(0);
			department.setTotalDeactiveEmployee(0);
			for(Employee employee:department.getEmployee()) {
				employee.setStatus(false);
				employee.setDepartment(null);
				employeeDao.updateEmployee(employee);
			}
		} else {
			department.setStatus(true);
		}
		departmentDao.updateDepartment(department);
		List<Department> departments = this.departmentDao.getDepartments();
		model.addAttribute("department", departments);
		return "department_table";
	}

	@RequestMapping("/department/update")
	public String UpdateForm(@RequestParam("id") int id, Model model) {
		Department department = this.departmentDao.getDepartment(id);
		model.addAttribute("department", department);
		return "update_department";
	}

	@RequestMapping("/departments")
	public String department(Model model) {
		List<User> users = this.userDao.getUsers();
		String ret = "";
		for (User user : users) {
			if (user.getName().equals(userController.username1)) {
				List<Department> departments = departmentDao.getDepartments();
//				List<Employee> employees = employeeDao.getemployees();
//				for (Department department : departments) {
//					int active = 0;
//					int deactive = 0;
//					for (Employee employee : department.getEmployee()) {
//						if (employee.isStatus() == true) {
//							++active;
//						} else {
//							++deactive;
//						}
//					}
//					model.addAttribute("active", active);
//					model.addAttribute("deactive", deactive);
//				}
				model.addAttribute("department", departments);
				ret = "department_table";
				break;

			} else {
				model.addAttribute("msg", "Please Login First");
				ret = "Login";
			}
		}
		return ret;

	}

}
