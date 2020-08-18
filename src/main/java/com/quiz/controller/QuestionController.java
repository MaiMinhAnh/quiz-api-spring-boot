package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.QuestionDTO;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("/quiz")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping(value = "/question/all")
	public List<QuestionDTO> getAllQuestion(){
		return questionService.getAllQuestion();
	}

	@GetMapping(value = "/question/{id}")
	public QuestionDTO getQuestionByID(@PathVariable ("id") Integer id) {
		return questionService.getQuestionByID(id);
	}
	
	@PostMapping(value = "/question/add")
	public void createQuestion(@RequestBody QuestionDTO questionDTO) {
		questionService.createQuestion(questionDTO);
	}
	
	@GetMapping(value = "/question/delete/{id}")
	public void deleteQuestion(@PathVariable("id") Integer id) {
		questionService.deleteQuestion(id);
	}
	
	@PostMapping(value = "/question/update/{id}")
	public void updateQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable ("id") Integer id) {
		questionService.updateQuestion(questionDTO, id);
	}
}
