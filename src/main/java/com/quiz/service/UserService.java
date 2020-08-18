package com.quiz.service;

import java.util.List;

import com.quiz.model.UserDTO;

public interface UserService {

	public List<UserDTO> getAllUser();
	
	public UserDTO getUserByID(int id_user);
	
	public void createUser(UserDTO userDTO);
	
	public void deleteUser(int id_user);
	
	public void updateUser(UserDTO userDTO, int id_user);
	
	public UserDTO loadUserByName(String username);
	
	public boolean checkLogin(UserDTO userDTO);
}
