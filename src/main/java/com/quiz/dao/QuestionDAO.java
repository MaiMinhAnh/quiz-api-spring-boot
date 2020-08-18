package com.quiz.dao;

import java.util.List;

import com.quiz.entity.Question;

public interface QuestionDAO {

	public List<Question> getAllQuestion();
	
	public Question getQuestionByID(int id_question);
	
	public void createQuestion(Question question);
	
	public void deleteQuestion(Question question);
	
	public void updateQuestion(Question question, int id_question);
	
	
}
