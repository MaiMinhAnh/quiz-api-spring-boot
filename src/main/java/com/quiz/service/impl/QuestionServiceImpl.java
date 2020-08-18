package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Answer;
import com.quiz.entity.Question;
import com.quiz.entity.User;
import com.quiz.model.QuestionDTO;
import com.quiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDAO questionDAO;
	
	@Override
	public List<QuestionDTO> getAllQuestion() {
		List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
		List<Question> questions = questionDAO.getAllQuestion();
		for(Question question: questions) {
			QuestionDTO questionDTO = new QuestionDTO();
			questionDTO.setId_question(question.getId_question());
			questionDTO.setId_user(question.getUser().getId_user());
			questionDTO.setUsername(question.getUser().getUsername());
			questionDTO.setQuestion(question.getQuestion());
			questionDTO.setAns1(question.getAns1());
			questionDTO.setAns2(question.getAns2());
			questionDTO.setAns3(question.getAns3());
			questionDTO.setAns4(question.getAns4());
			questionDTO.setAnswer(question.getAnswer().getAnswer());
			
			questionDTOs.add(questionDTO);
		}
		return questionDTOs;
	}

	@Override
	public QuestionDTO getQuestionByID(int id_question) {
		Question question = questionDAO.getQuestionByID(id_question);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setId_question(question.getId_question());
		questionDTO.setId_user(question.getUser().getId_user());
		questionDTO.setUsername(question.getUser().getUsername());
		questionDTO.setQuestion(question.getQuestion());
		questionDTO.setAns1(question.getAns1());
		questionDTO.setAns2(question.getAns2());
		questionDTO.setAns3(question.getAns3());
		questionDTO.setAns4(question.getAns4());
		questionDTO.setAnswer(question.getAnswer().getAnswer());
		
		return questionDTO;
	}

	@Override
	public void createQuestion(QuestionDTO questionDTO) {
		Question question = new Question();
		Answer answer = new Answer();
		User user = new User();
		question.setId_question(questionDTO.getId_question());
		question.setQuestion(questionDTO.getQuestion());
		question.setAns1(questionDTO.getAns1());
		question.setAns2(questionDTO.getAns2());
		question.setAns3(questionDTO.getAns3());
		question.setAns4(questionDTO.getAns4());
		answer.setQuestion(question);
		answer.setAnswer(questionDTO.getAnswer());
		question.setAnswer(answer);
		user.setId_user(questionDTO.getId_user());
		question.setUser(user);
		questionDAO.createQuestion(question);
		
	}

	@Override
	public void deleteQuestion(int id_question) {
		Question question = new Question();
		question=questionDAO.getQuestionByID(id_question);
		questionDAO.deleteQuestion(question);
		
	}

	@Override
	public void updateQuestion(QuestionDTO questionDTO, int id_question) {
		Question question = questionDAO.getQuestionByID(id_question);
		Answer answer = question.getAnswer();
		if (question!=null) {
			question.setQuestion(questionDTO.getQuestion());
			question.setAns1(questionDTO.getAns1());
			question.setAns2(questionDTO.getAns2());
			question.setAns3(questionDTO.getAns3());
			question.setAns4(questionDTO.getAns4());
			answer.setQuestion(question);
			answer.setAnswer(questionDTO.getAnswer());
			question.setAnswer(answer);
			//user.setId_user(questionDTO.getId_user());
			//question.setUser(user);
			
			questionDAO.updateQuestion(question, id_question);
		}
		
	}

}
