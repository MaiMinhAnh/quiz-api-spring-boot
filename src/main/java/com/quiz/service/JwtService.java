package com.quiz.service;

import java.util.Date;

import com.nimbusds.jwt.JWTClaimsSet;

public interface JwtService {

	public static final String USERNAME = "username";
	public static final String SECRET_KEY = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	public static final int EXPIRE_TIME = 86400000;
	
	public String generateTokenLogin(String username);
	
	public JWTClaimsSet getClaimsFromToken(String token);
	
	public Date generateExpirationDate();
	public Date getExpirationDateFromToken(String token);
	
	public String getUsernameFromToken(String token);
	
	public byte[] generateShareSecret();
	
	public Boolean isTokenExpired(String token);
	
	public Boolean validateTokenLogin(String token);
	
	
}
