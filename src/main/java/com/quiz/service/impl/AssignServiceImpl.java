package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.AssignDAO;
import com.quiz.entity.Assign;

import com.quiz.entity.Test;
import com.quiz.entity.User;
import com.quiz.model.AssignDTO;
import com.quiz.service.AssignService;

@Service
public class AssignServiceImpl implements AssignService {

	@Autowired
	private AssignDAO assignDAO;
	
	@Override
	public List<AssignDTO> getAllAssign() {
		List<AssignDTO> assignDTOs = new ArrayList<AssignDTO>();
		for(Assign assign: assignDAO.getAllAssign()) {
			
			AssignDTO assignDTO = new AssignDTO();
			
			assignDTO.setId_assign(assign.getId_assign());
			//assignDTO.setId_result(assign.getResult().getId_result());
			assignDTO.setId_test(assign.getTest().getId_test());
			assignDTO.setStart(assign.getStart());
			assignDTO.setEnd(assign.getEnd());
			assignDTO.setScore(assign.getScore());
			assignDTO.setId_user(assign.getUser().getId_user());
			
			assignDTOs.add(assignDTO);
		}
		return assignDTOs;
	}

	@Override
	public void createAssign(AssignDTO assignDTO) {
		Assign assign = new Assign();
		User user = new User();
		user.setId_user(assignDTO.getId_user());
		
		Test test = new Test();
		test.setId_test(assignDTO.getId_test());
		
		//Result result = new Result();
		//result.setId_result(assignDTO.getId_result());
		assign.setId_assign(assignDTO.getId_assign());
		//assign.setResult(result);
		assign.setTest(test);
		assign.setStart(getCurrentTime());
		assign.setEnd(getCurrentTime());
		assign.setScore(assignDTO.getScore());
		assign.setUser(user);
		
		assignDAO.createAssign(assign);
		
	}

	
	
	
	
	
	public static Date getCurrentTime() {
		return new Date();
	}
}
