package com.quiz.dao;

import java.util.List;

import com.quiz.entity.Question;
import com.quiz.entity.Test;

public interface TestDAO {

	public List<Question> getListQuestionTest();
	
	public void addTest(Test test);
	
	public List<Test> getAllTest();
	
	public Test getTestByID(int id_test);
	
	public void updateTest(Test test);
	
	public void deleteTest(Test test);
	
	
}
