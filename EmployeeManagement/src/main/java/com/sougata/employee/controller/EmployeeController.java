package com.sougata.employee.controller;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sougata.employee.dao.DepartmentDao;
import com.sougata.employee.dao.EmployeeDao;
import com.sougata.employee.model.Department;
import com.sougata.employee.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	UserController userController;


	// show add employee form
	@RequestMapping("/addemployee")
	public String addEmployee(Model m) {
		m.addAttribute("title", "Add Employee");
		List<Department> departments = this.departmentDao.getDepartments();
		m.addAttribute("department", departments);
		return "add_employee-form";
	}

	// Add New Employee Handler
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String createEmployee(@RequestParam("employeeId") String employeeId, @RequestParam("name") String name,
			@RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("department") String department, @RequestParam("mobileNumber") long mobileNumber,
			@RequestParam("email") String email, @RequestParam("address") String address,
			@RequestParam("aadharNumber") long aadharNumber, @RequestParam("remark") String remark,
			@RequestParam("employeePhoto") CommonsMultipartFile employeePhoto,
			@RequestParam("policeVerificationPhoto") CommonsMultipartFile policeVerificationPhoto,
			@RequestParam("employeeAadharPhoto") CommonsMultipartFile employeeAadharPhoto, Model model) {

		Department deptt = departmentDao.getDepartment(Integer.parseInt(department));
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setDepartment(deptt);
		employee.setMobileNumber(mobileNumber);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setAadharNumber(aadharNumber);
		employee.setCreatedBy(userController.username1);
		employee.setCreationTime(new Date());
		employee.setStatus(true);
		employee.setEmployeePhoto(employeePhoto.getBytes());
		employee.setPoliceVerificationPhoto(policeVerificationPhoto.getBytes());
		employee.setEmployeeAadharPhoto(employeeAadharPhoto.getBytes());
		employee.setRemark(remark);

		employeeDao.createEmployee(employee);

		deptt.setTotalEmployee(deptt.getTotalEmployee() + 1);
		deptt.setTotalActiveEmployee(deptt.getTotalActiveEmployee() + 1);
		departmentDao.updateDepartment(deptt);

		List<Employee> employees = employeeDao.getemployees();
		model.addAttribute("employee", employees);
		return "index";
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("department") String department, @RequestParam("mobileNumber") long mobileNumber,
			@RequestParam("email") String email, @RequestParam("address") String address,
			@RequestParam("aadharNumber") long aadharNumber, @RequestParam("remark") String remark, Model model) {

		Department olddepart = employeeDao.getEmployee(id).getDepartment();
		Department newdepart = departmentDao.getDepartment(Integer.parseInt(department));
		boolean oldStatus = employeeDao.getEmployee(id).isStatus();

		if (olddepart != null) {
			int oldid = olddepart.getId();
			int newid = newdepart.getId();
			System.out.println(
					olddepart.getName() + "     -department in       " + newdepart.getName() + "   -  " + oldStatus);
			System.out.println(oldid == newid);
			System.out.println(olddepart);
			System.out.println(newdepart);
			System.out.println(oldid);
			System.out.println(newid);
			if (oldid == newid) {
				if (!oldStatus) {
					System.out.println(olddepart.getName() + "     -false-       " + newdepart.getName()
							+ "   -same department-  " + oldStatus);

					newdepart.setTotalDeactiveEmployee(olddepart.getTotalDeactiveEmployee() - 1);
					newdepart.setTotalActiveEmployee(olddepart.getTotalActiveEmployee() + 1);
					departmentDao.updateDepartment(newdepart);
				}

			} else {
				if (!oldStatus) {
					System.out.println(olddepart.getName() + "     -false-       " + newdepart.getName()
							+ "   not same department-  " + oldStatus);

					newdepart.setTotalActiveEmployee(newdepart.getTotalActiveEmployee() + 1);
					newdepart.setTotalEmployee(newdepart.getTotalEmployee() + 1);

					olddepart.setTotalDeactiveEmployee(olddepart.getTotalDeactiveEmployee() - 1);
					olddepart.setTotalEmployee(olddepart.getTotalEmployee() - 1);
					departmentDao.updateDepartment(olddepart);
					departmentDao.updateDepartment(newdepart);
				} else {
					System.out.println(olddepart.getName() + "     -true-       " + newdepart.getName()
							+ "   -not same department-  " + oldStatus);

					newdepart.setTotalActiveEmployee(newdepart.getTotalActiveEmployee() + 1);
					newdepart.setTotalEmployee(newdepart.getTotalEmployee() + 1);

					olddepart.setTotalActiveEmployee(olddepart.getTotalActiveEmployee() - 1);
					olddepart.setTotalEmployee(olddepart.getTotalEmployee() - 1);
					departmentDao.updateDepartment(olddepart);
					departmentDao.updateDepartment(newdepart);
				}
			}
			// departmentDao.updateDepartment(olddepart);

		} else {
			System.out.println("     -department out       " + newdepart.getName() + "   -  " + oldStatus);

			newdepart.setTotalActiveEmployee(newdepart.getTotalActiveEmployee() + 1);
			newdepart.setTotalEmployee(newdepart.getTotalEmployee() + 1);
			departmentDao.updateDepartment(newdepart);

		}

		// departmentDao.updateDepartment(newdepart);

		Employee employee = employeeDao.getEmployee(id);
		employee.setName(name);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(department)));
		employee.setMobileNumber(mobileNumber);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setAadharNumber(aadharNumber);
		employee.setModifiedBy(userController.username1);
		employee.setModificationTime(new Date());
		employee.setStatus(true);
		employee.setRemark(remark);

		employeeDao.updateEmployee(employee);
		List<Employee> employees = employeeDao.getemployees();
		model.addAttribute("employee", employees);
		return "index";
	}

//	// delete Employee handler
//	@RequestMapping("/delete/{employeeId}")
//	public RedirectView deleteEmployee(@PathVariable("employeeId") int employeeId, HttpServletRequest request) {
//		this.employeeDao.deleteEmployee(employeeId);
//		RedirectView redirectview = new RedirectView();
//		redirectview.setUrl(request.getContextPath() + "/");
//		return redirectview;
//	}

	// update Employee handler
	@RequestMapping("/update")
	public String UpdateForm(@RequestParam("id") int id, Model model) {
		Employee employee = this.employeeDao.getEmployee(id);
		model.addAttribute("employee", employee);
		List<Department> departments = this.departmentDao.getDepartments();
		model.addAttribute("department", departments);
		return "update_form";
	}

	// update Employee status handler
	@RequestMapping("/update_employee_status")
	public String updateEmployeeStatus(@RequestParam("id") int id, @RequestParam("status") boolean status,
			Model model) {

		Employee employee = employeeDao.getEmployee(id);
		Department department = employeeDao.getEmployee(id).getDepartment();

		if (employee.getDepartment() == null) {
			model.addAttribute("msg", "Department not active");
			employee = this.employeeDao.getEmployee(id);
			List<Department> departments = this.departmentDao.getDepartments();
			model.addAttribute("department", departments);
			model.addAttribute("employee", employee);
			return "update_form";

		} else if (employee.isStatus() == true & employee.getDepartment().isStatus() == true) {
			employee.setStatus(false);
			department.setTotalDeactiveEmployee(department.getTotalDeactiveEmployee() + 1);
			department.setTotalActiveEmployee(department.getTotalActiveEmployee() - 1);
		} else if (employee.isStatus() == false & employee.getDepartment().isStatus() == true) {
			employee.setStatus(true);
			department.setTotalDeactiveEmployee(department.getTotalDeactiveEmployee() - 1);
			department.setTotalActiveEmployee(department.getTotalActiveEmployee() + 1);
		} else if (employee.isStatus() == false & employee.getDepartment().isStatus() == false) {
			employee.setStatus(false);
			model.addAttribute("msg", "Department is not Active");
		} else {
			model.addAttribute("msg", "Department not active");
			employee = this.employeeDao.getEmployee(id);
			List<Department> departments = this.departmentDao.getDepartments();
			model.addAttribute("department", departments);
			model.addAttribute("employee", employee);
			return "update_form";
		}
		departmentDao.updateDepartment(department);
		employeeDao.updateEmployee(employee);
		List<Employee> employees = this.employeeDao.getemployees();
		model.addAttribute("employee", employees);
		return "index";
	}

	// Show All Employee Handler
	@RequestMapping("/employee")
	public String employee(Model m) {

		List<Employee> employees = employeeDao.getemployees();
		m.addAttribute("employee", employees);

		return "index";
	}

	// View employee with details handler
	@RequestMapping("/view_employee")
	public String viewEmployeeDetails(@RequestParam("id") int id, Model model) {
		Employee employee = employeeDao.getEmployee(id);

		byte[] employeePhoto = employee.getEmployeePhoto();
		String employee_photo = Base64.getEncoder().encodeToString(employeePhoto);
		model.addAttribute("employeePhoto", employee_photo);

		byte[] policeVerificationPhoto = employee.getPoliceVerificationPhoto();
		String police_verification_photo = Base64.getEncoder().encodeToString(policeVerificationPhoto);
		model.addAttribute("policeVerificationPhoto", police_verification_photo);

		byte[] employeeAadharPhoto = employee.getEmployeeAadharPhoto();
		String employee_aadhar_photo = Base64.getEncoder().encodeToString(employeeAadharPhoto);
		model.addAttribute("employeeAadharPhoto", employee_aadhar_photo);

		model.addAttribute("employee", employee);
		return "view_employee_details";
	}

}
