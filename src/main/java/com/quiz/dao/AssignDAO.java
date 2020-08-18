package com.quiz.dao;

import java.util.List;

import com.quiz.entity.Assign;

public interface AssignDAO {

	public List<Assign> getAllAssign();
	
	public void createAssign(Assign assign);
	
}
