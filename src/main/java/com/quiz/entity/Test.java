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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "test")
@Data
public class Test implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_test;
	
	
	@Column(name = "name")
	private String name;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "test_question", joinColumns = @JoinColumn(name = "id_test"),  
	inverseJoinColumns = @JoinColumn(name = "id_question") )
	private List<Question> questions;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@OneToOne(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Assign assign;

}
