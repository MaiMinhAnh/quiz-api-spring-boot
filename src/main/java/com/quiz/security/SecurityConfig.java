package com.quiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.quiz.rest.CustomAccessDeniedHandler;
import com.quiz.rest.JwtAuthenticationTokenFilter;
import com.quiz.rest.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
		JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
		jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
		return jwtAuthenticationTokenFilter;
	}

	@Bean
	public RestAuthenticationEntryPoint restServicesEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}

	@Bean
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
	    return super.authenticationManager();
	  }

	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().ignoringAntMatchers("/quiz/**");
		http.authorizeRequests().antMatchers("/quiz/login**").permitAll();
		
		http.antMatcher("/quiz/**")
			.httpBasic()
			.authenticationEntryPoint(restServicesEntryPoint())
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/quiz/user/**").hasRole("ADMIN")
			.antMatchers("/quiz/question/**").hasRole("TEACHER")
			.antMatchers("/quiz/test/**").hasAnyRole("TEACHER", "STUDENT")
			.antMatchers("/quiz/assign/**").hasAnyRole("TEACHER", "STUDENT")
			.and()
			.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling()
			.accessDeniedHandler(customAccessDeniedHandler())
			.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error")
			.and()
			.exceptionHandling()
				.accessDeniedPage("/403");
			
	}

}
