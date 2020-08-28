package com.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dao.UserDAO;


import com.quiz.model.UserDTO;
import com.quiz.service.JwtService;
import com.quiz.service.UserService;

@RestController
@RequestMapping("/quiz")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	UserDAO userDAO;
	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtService jwtService;
	
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUser(){
		return new ResponseEntity<List<UserDTO>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserDTO getUserByID(@PathVariable("id") Integer id) {
		return userService.getUserByID(id);
	}
	
	@PostMapping(value = "/user/add")
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
	}
	
	@GetMapping(value = "/user/delete/{id}")
	public void deleteUser(@PathVariable ("id") Integer id) {
		userService.deleteUser(id);
	}
	
	@PostMapping(value = "/user/update/{id}")
	public void updateUser(@RequestBody UserDTO userDTO, @PathVariable ("id") Integer id) {
		userService.updateUser(userDTO, id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody UserDTO userDTO){
		String resultString="";
		HttpStatus httpStatus = null;
		try {
			if (userService.checkLogin(userDTO)) {
				resultString= jwtService.generateTokenLogin(userDTO.getUsername());
				httpStatus=HttpStatus.OK;
				
			}else {
				resultString="Wrong ";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO: handle exception
			resultString = "server error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<String>(resultString, httpStatus);
	}
	
//	@PostMapping("/login")
//	Object oneByUsernamePassword(@RequestBody User user) {
//		User a = userDAO.loadUserByName(user.getUsername());
//		//if (a != null) {
//			final String token = jwtTokenUtil.generateToken(a);
//			UserDTO adto = new UserDTO(a.getId_user(), a.getUsername(), a.getPassword(), a.getRole().getId_role(), token);
//			return adto;
//		
//		
//	}
	@PostMapping(value = "/getUserByName")
	public UserDTO getUserByName(@RequestBody UserDTO userDTO) {
		return userService.loadUserByName(userDTO.getUsername());
	}
	
	
}
