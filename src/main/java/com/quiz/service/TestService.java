package com.quiz.service;

import java.util.List;

import com.quiz.model.TestDTO;

public interface TestService {

	public void addTest(TestDTO testDTO);
	
	public void deleteTest(int id_test);
	
	
	public List<TestDTO> getAllTest();
	
	public TestDTO getTestByID(int id_test);
	
	public void updateTest(TestDTO testDTO ,int id_test);
	

	
	
}
