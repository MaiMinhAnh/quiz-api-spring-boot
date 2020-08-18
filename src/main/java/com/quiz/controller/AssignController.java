package com.quiz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.AssignDTO;
import com.quiz.service.AssignService;

@RestController
@RequestMapping("/quiz")
public class AssignController {

	@Autowired
	private AssignService assignService;
	
	@GetMapping(value = "/assign/all")
	public List<AssignDTO> getAllAssign(){
		return assignService.getAllAssign();
	}
	
	@PutMapping(value = "/assign/create")
	public void createAssign(@RequestBody AssignDTO assignDTO) {
		assignService.createAssign(assignDTO);
	}
	
	
	
	
	
	

	
}
