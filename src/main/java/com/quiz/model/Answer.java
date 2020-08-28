package com.quiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {

	private int id_answer;
	private int answer;
	private int id_question;
	
	
	public Answer(int id_answer, int answer) {
		super();
		this.id_answer = id_answer;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
