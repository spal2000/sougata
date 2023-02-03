package com.sougata.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sougata.employee.model.User;

@Component
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.save(user);

	}

	@Transactional
	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}

	public List<User> getUsers() {

		List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}

	public User getUser(int id) {

		return this.hibernateTemplate.get(User.class, id);

	}

}
