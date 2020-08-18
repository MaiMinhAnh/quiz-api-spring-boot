package com.quiz.service;

import java.util.List;

import com.quiz.model.QuestionDTO;

public interface QuestionService {

	public List<QuestionDTO> getAllQuestion();
	
	public QuestionDTO getQuestionByID(int id_question);
	
	public void createQuestion(QuestionDTO questionDTO);
	
	public void deleteQuestion(int id_question);
	
	public void updateQuestion(QuestionDTO questionDTO, int id_question);
	
}
