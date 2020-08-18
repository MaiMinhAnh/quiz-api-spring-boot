package com.quiz.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;


import com.quiz.model.TestQuestionDTO;
import com.quiz.service.TestQuestionService;

@Service
public class TestQuestionServiceImpl implements TestQuestionService {

//	@Autowired
//	private TestQuestionDAO testQuestionDAO;
//	
//	@Override
//	public void createTestQuestion(TestQuestionDTO testQuestionDTO) {
//	
//		TestQuestion testQuestion = new TestQuestion();
//		testQuestion.setId(testQuestionDTO.getId());
//		
//		List<Question> questions = testQuestionDAO.getListQuestionTest();
//		List<Integer> questionIDList = new ArrayList<Integer>();
//		for(Question q: questions) {
//			q.setTestQuestion(testQuestion);
//			questionIDList.add(q.getId_question());
//		}
//		testQuestion.setQuestionList(questions);
//		testQuestionDTO.setQuestionIDList(questionIDList);
//		
//		testQuestionDAO.createTestQuestion(testQuestion);
//		
//		}
//		
//
//	@Override
//	public List<TestQuestionDTO> getAllTestQuestion() {
//		List<TestQuestionDTO> testQuestionDTOs = new ArrayList<TestQuestionDTO>();
//		List<TestQuestion> testQuestions= testQuestionDAO.getAllTestQuestion();
//		for(TestQuestion testQuestion: testQuestions) {
//			TestQuestionDTO testQuestionDTO = new TestQuestionDTO();
//			testQuestionDTO.setId(testQuestion.getId());
//			List<Integer> questionIDList = new ArrayList<Integer>();
//			for(Question q: testQuestion.getQuestionList()) {
//				questionIDList.add(q.getId_question());
//			}
//			
//			List<String> testNameList = new ArrayList<String>();
//			for(Test test: testQuestion.getTestList()) {
//				testNameList.add(test.getName());
//			}
//			
//			
//			testQuestionDTO.setQuestionIDList(questionIDList);
//			testQuestionDTO.setTestNameList(testNameList);
//			
//			testQuestionDTOs.add(testQuestionDTO);
//		}
//		return testQuestionDTOs;
//	}

	@Override
	public void createTestQuestion(TestQuestionDTO testQuestionDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestQuestionDTO> getAllTestQuestion() {
		// TODO Auto-generated method stub
		return null;
	}




}
