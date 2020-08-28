package com.quiz.dao;

import java.util.List;

import com.quiz.entity.Assign;

public interface AssignDAO {

	public List<Assign> getAllAssign();
	
	public void createAssign(Assign assign);
	
	public Assign getAssignById(int id_assign);
	
	public List<Assign> getAssignByUser(String username);
	
}
