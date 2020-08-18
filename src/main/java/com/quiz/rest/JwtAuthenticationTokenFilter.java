package com.quiz.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;


import com.quiz.model.UserDTO;
import com.quiz.service.JwtService;
import com.quiz.service.UserService;



public class JwtAuthenticationTokenFilter  extends UsernamePasswordAuthenticationFilter{

	private final static String TOKEN_HEADER="authorization";
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	public void doFilter(ServletRequest request, ServletResponse response,
							FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authToken= httpServletRequest.getHeader(TOKEN_HEADER);
		
		if (jwtService.validateTokenLogin(authToken)) {
			String username= jwtService.getUsernameFromToken(authToken);
			
			UserDTO userDTO = userService.loadUserByName(username);
			if (userDTO!=null) {
				boolean enabled=true;
				boolean accontNonExpired= true;
				boolean credentialsNonExpired= true;
				boolean accountNonLocked= true;
				
				UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, userDTO.getPassword(), enabled, accontNonExpired,
												credentialsNonExpired, accountNonLocked, userDTO.getAuthorities());
				
			
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			
			
		}
		
		chain.doFilter(request, response);
		
		
		
	}
	
	
}
