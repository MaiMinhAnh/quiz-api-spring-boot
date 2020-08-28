package com.quiz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.TestDAO;
import com.quiz.entity.Question;
import com.quiz.entity.Test;

@Transactional
@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Question> getListQuestionTest() {
		String jql="select question from Question question order by rand()";
		return entityManager.createQuery(jql, Question.class).setMaxResults(5).getResultList();
	}

	@Override
	public void addTest(Test test) {
		entityManager.persist(test);
		
	}

	@Override
	public void deleteTest(Test test) {
		entityManager.remove(test);
		
	}

	@Override
	public List<Test> getAllTest() {
		String jql="select test from Test test";
		return entityManager.createQuery(jql, Test.class).getResultList();
	}

	@Override
	public Test getTestByID(int id_test) {
		return entityManager.find(Test.class, id_test);
	}

	@Override
	public void updateTest(Test test) {
		entityManager.merge(test);
		
	}

	@Override
	public Test getTestByName(String name) {
		Test test = (Test) entityManager.createQuery("select t from Test t where t.name like:testName")
				.setParameter("testName", name).getSingleResult();
	return test;
	}




}
