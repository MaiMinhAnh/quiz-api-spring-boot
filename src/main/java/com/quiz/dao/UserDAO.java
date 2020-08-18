package com.quiz.dao;

import java.util.List;

import com.quiz.entity.User;

public interface UserDAO {

	public List<User> getAllUser();
	
	public User getUserByID(int id_user);
	
	public void createUser(User user);
	
	public void deleteUser(User user);
	
	public User updateUser(User user, int id_user);
	
	public User loadUserByName(String username);
}
