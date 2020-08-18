package com.quiz.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "question")
@Data
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_question;
	
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "ans1")
	private String ans1;
	
	@Column(name = "ans2")
	private String ans2;
	
	@Column(name = "ans3")
	private String ans3;
	
	@Column(name = "ans4")
	private String ans4;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@OneToOne(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Answer answer;
	
//	@OneToOne(mappedBy = "questionList", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	private TestQuestion testQuestion;
	
	
	@ManyToMany(mappedBy = "questions")
	private List<Test> tests;
	
}
