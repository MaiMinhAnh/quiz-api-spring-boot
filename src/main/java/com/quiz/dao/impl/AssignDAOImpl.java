package com.quiz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.AssignDAO;
import com.quiz.entity.Assign;

@Transactional
@Repository
public class AssignDAOImpl implements AssignDAO {

	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<Assign> getAllAssign() {
		String jql="select assign from Assign assign";
		return entityManager.createQuery(jql, Assign.class).getResultList();
	}


	@Override
	public void createAssign(Assign assign) {
		entityManager.persist(assign);
		
	}

}
