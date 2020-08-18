package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.TestDTO;
import com.quiz.service.TestService;

@RestController
@RequestMapping("/quiz")
public class TestController {

	@Autowired
	private TestService testService;
	
	@PostMapping(value = "/test/add")
	public void addTest(@RequestBody TestDTO testDTO) {
		testService.addTest(testDTO);
	}
	
	@GetMapping(value = "/test/all")
	public List<TestDTO> getAllTest(){
		return testService.getAllTest();
	}
	
	@GetMapping(value = "/test/{id}")
	public TestDTO getTestByID(@PathVariable ("id") Integer id) {
		return testService.getTestByID(id);
	}
	
	@GetMapping(value = "/test/delete/{id}")
	public void deleteTest(@PathVariable("id") Integer id) {
		testService.deleteTest(id);
	}
	
	@PutMapping(value = "/test/update/{id}")
	public void updateTest(@RequestBody TestDTO testDTO, @PathVariable("id") Integer id) {
		testService.updateTest(testDTO, id);
	}

	
	
	
	
}
