package com.quiz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.TestQuestionDAO;
import com.quiz.entity.Question;
import com.quiz.entity.Test;
import com.quiz.entity.TestQuestion;

@Transactional
@Repository
public class TestQuestionDAOImpl implements TestQuestionDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Question> getListQuestionTest() {
		String jql="select question from Question question order by rand()";
		return entityManager.createQuery(jql, Question.class).setMaxResults(5).getResultList();
	}

	@Override
	public void createTestQuestion(TestQuestion testQuestion) {
		entityManager.persist(testQuestion);
		
	}

	@Override
	public List<TestQuestion> getAllTestQuestion() {
		String jql="select testQuestion from TestQuestion testQuestion";
		return entityManager.createQuery(jql, TestQuestion.class).getResultList();
	}

	@Override
	public List<Test> getAllTest() {
		String jql= "select test from Test test";
		return entityManager.createQuery(jql, Test.class).getResultList();
	}

}
