package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.TestDAO;
import com.quiz.entity.Question;
import com.quiz.entity.Test;
import com.quiz.entity.User;
import com.quiz.model.TestDTO;
import com.quiz.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDAO testDAO;
	
	
	//them test moi can truyen vaof ten, hej thong tu dong lay 5 au hoi bat ki trogn database, id test tu tang
	@Override
	public void addTest(TestDTO testDTO) {
		List<Question> questions = testDAO.getListQuestionTest();
		List<Question> questionTestList = new ArrayList<Question>();
		Test test = new Test();
		User user = new User();
		user.setId_user(testDTO.getId_user());
		for(Question q: questions) {
			questionTestList.add(q);
		}
		test.setName(testDTO.getName());
		test.setQuestions(questionTestList);
		test.setUser(user);
		testDAO.addTest(test);
		
	}



	@Override
	public List<TestDTO> getAllTest() {
		List<TestDTO> testDTOs = new ArrayList<TestDTO>();
		//List<Test> tests = testDAO.getAllTest();
		for(Test test: testDAO.getAllTest()) {
			TestDTO testDTO = new TestDTO();
			List<Integer> questionIDList = new ArrayList<Integer>();
			testDTO.setId_test(test.getId_test());
			testDTO.setName(test.getName());
			for(Question q: test.getQuestions()) {
				questionIDList.add(q.getId_question());
			}
			testDTO.setQuestionIDList(questionIDList);
			testDTO.setId_user(test.getUser().getId_user());
			//testDTO.setId_assign(test.getAssign().getId_assign());
			
			testDTOs.add(testDTO);
			
		}
		return testDTOs;
	}

	@Override
	public TestDTO getTestByID(int id_test) {
		TestDTO testDTO = new TestDTO();
		Test test = testDAO.getTestByID(id_test);
		testDTO.setId_test(test.getId_test());
		testDTO.setName(test.getName());
		
		List<Integer> questionIDList = new ArrayList<Integer>();
		for(Question question: test.getQuestions()) {
			questionIDList.add(question.getId_question());
		}
		
		testDTO.setQuestionIDList(questionIDList);
		testDTO.setId_user(test.getUser().getId_user());
		//testDTO.setId_assign(test.getAssign().getId_assign());
		
		return testDTO;
	}
	
	@Override
	public void deleteTest(int id_test) {
		Test test = testDAO.getTestByID(id_test);
		testDAO.deleteTest(test);
		
	}



	@Override
	public void updateTest(TestDTO testDTO, int id_test) {
		Test test = testDAO.getTestByID(id_test);
		if (test != null) {
			test.setName(testDTO.getName());
			
			testDAO.updateTest(test);
		}
		
	}






}
