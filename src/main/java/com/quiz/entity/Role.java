package com.quiz.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "id_role")
	private int id_role;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users;
	
	
}
