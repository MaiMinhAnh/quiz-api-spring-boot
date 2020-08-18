package com.quiz.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Entity
@Table(name = "user")
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"role","authorities"})
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_user;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Test> tests;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Assign> assigns;
	
	
//	public User(int id, String username, String password) {
//		super();
//		this.id_user = id;
//		this.username = username;
//		this.password = password;
//	}
	
	public List<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		return authorities;
	}
	
}
