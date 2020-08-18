package com.quiz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "test_question")
@Data
public class TestQuestion implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JoinColumn(name = "id_question")
	private int id_question;

	@JoinColumn(name = "id_test")
	private int id_test;

	@Column(name = "name")
	private String name;


}
