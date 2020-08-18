package com.quiz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.quiz.model.TestQuestionDTO;
import com.quiz.service.TestQuestionService;

@RestController
public class TestQuestionController {

	@Autowired
	private TestQuestionService testQuestionService;
	
	
	@GetMapping(value = "/testquestion/getall")
	public List<TestQuestionDTO> getAllTestQuestion(){
		return testQuestionService.getAllTestQuestion();
	}
	
	@PostMapping(value = "/teacher/add/test")
	public void createTestQuestion(@RequestBody TestQuestionDTO testQuestionDTO) {
		testQuestionService.createTestQuestion(testQuestionDTO);
	}
	
}
