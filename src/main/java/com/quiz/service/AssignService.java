package com.quiz.service;

import java.util.List;

import com.quiz.model.AssignDTO;

public interface AssignService {

	public List<AssignDTO> getAllAssign();
	
	public void createAssign(AssignDTO assignDTO);
	
	public AssignDTO getAssignById(int id_assign);
	
	public List<AssignDTO> getAssignByUser(String username);
	
}
