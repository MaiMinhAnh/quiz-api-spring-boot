package com.quiz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Question;

@Transactional
@Repository
public class QuestionDAOImpl implements QuestionDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Question> getAllQuestion() {
		String jql="select question from Question question";
		return entityManager.createQuery(jql, Question.class).getResultList();
	}

	@Override
	public Question getQuestionByID(int id_question) {
		return entityManager.find(Question.class, id_question);
	}

	@Override
	public void createQuestion(Question question) {
		entityManager.persist(question);
		
	}

	@Override
	public void deleteQuestion(Question question) {
		entityManager.remove(question);
		
	}

	@Override
	public void updateQuestion(Question question, int id_question) {
		entityManager.merge(question);
		
	}

}
