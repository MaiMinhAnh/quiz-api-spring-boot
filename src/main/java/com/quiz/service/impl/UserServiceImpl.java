package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.UserDAO;
import com.quiz.entity.Assign;
import com.quiz.entity.Role;
import com.quiz.entity.Test;
import com.quiz.entity.User;
import com.quiz.model.UserDTO;
import com.quiz.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserDAO userDao;
	
	
	//lay het danh sach nguoi dung
	@Override
	public List<UserDTO> getAllUser() {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<User> users = userDao.getAllUser();
		for(User u: users) {
			UserDTO userDTO = new UserDTO();
			List<Integer> testIDList = new ArrayList<Integer>();
			for(Test test: u.getTests()) {
				testIDList.add(test.getId_test());
			}
			userDTO.setTestIDList(testIDList);
			
			List<Integer> assignIDList = new ArrayList<Integer>();
			for(Assign assign : u.getAssigns()) {
				assignIDList.add(assign.getId_assign());
			}
			userDTO.setAssignIDList(assignIDList);
			
			userDTO.setId_user(u.getId_user());
			userDTO.setUsername(u.getUsername());
			userDTO.setPassword(u.getPassword());
			userDTO.setRole(u.getRole().getId_role());
			userDTO.setRole_name(u.getRole().getName());
			
			userDTOs.add(userDTO);
		}
		
		return userDTOs;
	}

	
	
	//lay du lieu 1 nguoi dung
	@Override
	public UserDTO getUserByID(int id_user) {
		UserDTO userDTO = new UserDTO();
		User user = new User();
		user = userDao.getUserByID(id_user);
		
		List<Integer> testIDList = new ArrayList<Integer>();
		for(Test test: user.getTests()) {
			testIDList.add(test.getId_test());
		}
		userDTO.setTestIDList(testIDList);
		
		List<Integer> assignIDList = new ArrayList<Integer>();
		for(Assign assign: user.getAssigns()) {
			assignIDList.add(assign.getId_assign());
		}
		userDTO.setAssignIDList(assignIDList);
		
		
		userDTO.setId_user(user.getId_user());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole().getId_role());
		userDTO.setRole_name(user.getRole().getName());
		
		return userDTO;
	}

	@Override
	public void createUser(UserDTO userDTO) {
		User user = new User();
		Role role = new Role();
		List<User> userList = new ArrayList<User>();
		user.setId_user(userDTO.getId_user());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		role.setId_role(userDTO.getRole());
		role.setName(userDTO.getRole_name());
		userList.add(user);
		user.setRole(role);
		role.setUsers(userList);
		
		userDao.createUser(user);
		
	}

	@Override
	public void deleteUser(int id_user) {
		User user = new User();
		user= userDao.getUserByID(id_user);
		userDao.deleteUser(user);
		
	}

	@Override
	public void updateUser(UserDTO userDTO, int id_user) {
		User user = new User();
		Role role = new Role();
		user = userDao.getUserByID(id_user);
		if (user!=null) {
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			role.setId_role(userDTO.getRole());
			user.setRole(role);
			
			userDao.updateUser(user, id_user);
		}
		
		
	}



	@Override
	public UserDTO loadUserByName(String username) {


		UserDTO userDTO = new UserDTO();
		User user = new User();
		user = userDao.loadUserByName(username);
		
//		List<Integer> testIDList = new ArrayList<Integer>();
//		for(Test test: user.getTests()) {
//			testIDList.add(test.getId_test());
//		}
//		userDTO.setTestIDList(testIDList);
		
//		List<Integer> assignIDList = new ArrayList<Integer>();
//		for(Assign assign: user.getAssigns()) {
//			assignIDList.add(assign.getId_assign());
//		}
//		userDTO.setAssignIDList(assignIDList);
		
		
		userDTO.setId_user(user.getId_user());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole().getId_role());
		userDTO.setRole_name(user.getRole().getName());
		userDTO.setAuthorities(user.getAuthorities());
		
		return userDTO;
	}



	@Override
	public boolean checkLogin(UserDTO userDTO) {
//		for (User userExist : listUsers) {
//			if (StringUtils.equals(user.getUsername(), userExist.getUsername())
//					&& StringUtils.equals(user.getPassword(), userExist.getPassword())) {
//				return true;
//			}
//		}
		User user = userDao.loadUserByName(userDTO.getUsername());
		if(StringUtils.equals(user.getPassword(), userDTO.getPassword())) {
			return true;
		}	
		
		return false;
		
	}

}
