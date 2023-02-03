package com.sougata.employee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sougata.employee.dao.UserDao;
import com.sougata.employee.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	/*
	 * @Autowired private EmailService emailService;
	 */

	String username1 = "";
	String _username = "";

	/*
	 * @RequestMapping(value = "/send-email", method = RequestMethod.POST) public
	 * String sendEmail() { User user = new User(); try {
	 * emailService.sendWelcomeEmail(user); return "email-sent"; } catch
	 * (MessagingException e) { e.printStackTrace(); return "email-error"; } }
	 */

	// open login page handler
	@RequestMapping("/")
	public String home() {
		return "Login";
	}

	@RequestMapping("/Register")
	public String viewregisterUser(Model model) {
		model.addAttribute("title", "Add User");
		return "Register";
	}

	@RequestMapping("/login")
	public String viewLoginPage() {
		return "Login";
	}

	@RequestMapping("/home")
	public String viewHomePage(Model model) {
		model.addAttribute("title", "Home");
		List<User> users = this.userDao.getUsers();
		String ret = "";
//		System.out.println(_username);
		System.out.println(username1);
		for (User user : users) {
			if (user.getUserName().equals(_username)) {
				ret = "home";
				break;
			} else {
				model.addAttribute("msg", "Please Login First");
				ret = "Login";
			}
		}
		return ret;
	}

	@RequestMapping(path = "/register_user", method = RequestMethod.POST)
	public String registerUser(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam("name") String name, @RequestParam("password") String Password, Model model) {

		List<User> users = this.userDao.getUsers();

		String ret = "";
		for (User user_check : users) {
			if (user_check.getName().equals(username1)) {
				System.out.println("ij");
				for (User user1 : users) {
					if (userName.equals(user1.getUserName())) {
						System.out.println("okokkkk");
						model.addAttribute("user", users);
						model.addAttribute("msg", "User already Exist");
						return "Register";
					}
				}
				User user = new User();
				user.setUserName(userName);
				user.setName(name);
				user.setPassword(Password);

				user.setStatus(true);
				System.out.println(username1);
				user.setCreatedBy(username1);
				user.setCreationTime(new Date());
				userDao.createUser(user);
				users = this.userDao.getUsers();
				model.addAttribute("msg", "User added Successfully");
				model.addAttribute("user", users);
				ret = "user_table";
				break;
			} else {
				ret = "Login";
			}
		}

		return ret;

	}

	@RequestMapping(path = "/update_user", method = RequestMethod.POST)
	public String updateUser(@RequestParam("id") int id,
			@RequestParam(name = "userName", required = true) String userName, @RequestParam("name") String name,
			@RequestParam("password") String Password, Model model) {
		User user = userDao.getUser(id);
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(Password);
		user.setStatus(true);
		System.out.println(username1);
		user.setModifiedBy(username1);
		user.setModificationTime(new Date());
		userDao.updateUser(user);

		List<User> users = this.userDao.getUsers();
		model.addAttribute("user", users);

		return "user_table";
	}

	@RequestMapping("/update_status")
	public String updateUserStatus(@RequestParam("id") int id, @RequestParam("status") boolean status, Model model) {
		List<User> users = this.userDao.getUsers();
		int status_count = 0;
		String ret = "";
		for (User user1 : users) {
			if (user1.isStatus() == true) {
				++status_count;
			}
		}
		if (status_count == 1) {
			User usr = userDao.getUser(id);
			if (!usr.isStatus()) {
				usr.setStatus(true);
				userDao.updateUser(usr);
			} else {
				model.addAttribute("msg", "all user can not be deactivated");
			}
			users = this.userDao.getUsers();
			model.addAttribute("user", users);
			model.addAttribute("msg", "Status changed successfully");
			ret = "user_table";
		} else {
			User user = userDao.getUser(id);
			if (user.isStatus() == true & status_count > 1) {
				user.setStatus(false);
			} else {

				user.setStatus(true);
			}
			userDao.updateUser(user);
			users = this.userDao.getUsers();
			model.addAttribute("user", users);
			model.addAttribute("msg", "Status changed successfully");
			ret = "user_table";

		}
		return ret;
	}

	@RequestMapping("/user/update")
	public String UpdateForm(@RequestParam("id") int id, Model model) {
		User user = this.userDao.getUser(id);
		model.addAttribute("user", user);
		return "update_user";
	}

	@RequestMapping(path = "/login_user", method = RequestMethod.POST)
	public String loginUser(@RequestParam(name = "userName", required = true) String username,
			@RequestParam("password") String password, Model model) {
		// System.out.println("inide loginuser");
		List<User> users = userDao.getUsers();
		String ret = "";

		for (User user : users) {
//			System.out.println("=====gu====" + user.getUserName());
//			System.out.println("---gp----"+user.getPassword());
//			System.out.println("=========u==========" + username);
//			System.out.println("--p--"+password);
//			 ret ="";
			if (user.getUserName().equals(username) & user.getPassword().equals(password)) {
				if (user.isStatus()) {
					username1 = user.getName();
					_username = user.getUserName();
					return "home";
				} else {
					model.addAttribute("msg", " User is Inacitve");
					return "Login";
				}
			} else {
				model.addAttribute("msg", "Invalid username or password");
				ret = "Login";
			}
		}
		return ret;

	}

	@RequestMapping("/user")
	public String user(Model m) {

		List<User> users = userDao.getUsers();
		m.addAttribute("user", users);
		System.out.println(username1);
		return "user_table";
	}

	@RequestMapping("/log_out")
	public String logOut(Model model) {

		username1 = "";
		_username = "";
		return "Login";

	}
}