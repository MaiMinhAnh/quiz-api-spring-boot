package com.quiz.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "assign")
@Data
public class Assign implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id_assign;
	
	
	@Column(name = "start")
	private Date start;
	
	@Column(name = "end")
	private Date end;
	
	@Column(name = "score")
	private int score;
	
	@OneToOne
	@JoinColumn(name = "id_test")
	private Test test;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@OneToOne(mappedBy = "assign")
	private Result result;
	
}
