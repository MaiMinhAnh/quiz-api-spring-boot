package com.quiz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "result")
@Data
public class Result implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id_result;
	
	@Column(name = "id_question")
	private int id_question;
	
	@Column(name = "id_choice")
	private int id_choice;
	
	@OneToOne
	@JoinColumn(name = "id_assign")
	private Assign assign;
	
	
}
