package com.quiz.service;


import java.util.List;


import com.quiz.model.TestQuestionDTO;

public interface TestQuestionService {

	public void createTestQuestion(TestQuestionDTO testQuestionDTO);
	
	public List<TestQuestionDTO> getAllTestQuestion();
	
	
}
