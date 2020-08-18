package com.quiz.dao;

import java.util.List;

import com.quiz.entity.Question;
import com.quiz.entity.Test;
import com.quiz.entity.TestQuestion;

public interface TestQuestionDAO {

	public List<Question> getListQuestionTest();
	
	public void createTestQuestion(TestQuestion testQuestion);
	
	public List<TestQuestion> getAllTestQuestion();
	
	public List<Test> getAllTest();
}
