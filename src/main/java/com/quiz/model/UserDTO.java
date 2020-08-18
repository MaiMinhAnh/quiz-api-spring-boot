package com.quiz.model;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int id_user;
	private String username;
	private String password;
	private int role;
	private String role_name;
	
	private List<Integer> questionIDList;
	private List<Integer> testIDList;
	
	private List<Integer> assignIDList;
	
	private List<GrantedAuthority> authorities;



	
	
	
}
