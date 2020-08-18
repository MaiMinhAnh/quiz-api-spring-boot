package com.quiz.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.UserDAO;
import com.quiz.entity.User;

@Transactional
@Repository
public class UserDAOImpl  implements UserDAO{

	@Autowired
	private EntityManager enityManager;
	
	
	@Override
	public List<User> getAllUser() {
		String jql= "select user from User user";
		return enityManager.createQuery(jql, User.class).getResultList();
	}

	@Override
	public User getUserByID(int id_user) {
		return enityManager.find(User.class, id_user);
	}

	@Override
	public void createUser(User user) {
		enityManager.persist(user);
		
	}

	@Override
	public void deleteUser(User user) {
		enityManager.remove(user);
		
	}

	@Override
	public User updateUser(User user, int id_user) {
		return enityManager.merge(user);
	}

	

	@Override
	public User loadUserByName(String username) {
		User user = new User();
		/*
		 * entityManager.
		 * createNativeQuery("INSERT INTO Employees (name,  age) VALUES (?,?)")
		 * .setParameter(1, employees.getName()) .setParameter(2, employees.getAge())
		 * 
		 * .executeUpdate();
		 */
		
		user = (User) enityManager.createQuery("select u from User u where u.username like:userName")
					.setParameter("userName", username).getSingleResult();
		return user;
	}	

}
