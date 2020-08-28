package com.quiz.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.quiz.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService{

	@Override
	public String generateTokenLogin(String username) {
		String token= null;
		try {
			JWSSigner signer = new MACSigner(generateShareSecret());
			
			JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
			builder.claim(USERNAME, username);
			builder.expirationTime(generateExpirationDate());
			
			JWTClaimsSet claimsSet = builder.build();
			SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
			
			signedJWT.sign(signer);
			
			token = signedJWT.serialize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return token;
	}

	@Override
	public JWTClaimsSet getClaimsFromToken(String token) {
		JWTClaimsSet claims= null;
		try {
			SignedJWT signedJWT = SignedJWT.parse(token);
			JWSVerifier verifier = new MACVerifier(generateShareSecret());
			if (signedJWT.verify(verifier)) {
				claims= signedJWT.getJWTClaimsSet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claims;
	}

	@Override
	public Date generateExpirationDate() {
		
		return new Date(System.currentTimeMillis()+EXPIRE_TIME);
	}

	@Override
	public Date getExpirationDateFromToken(String token) {
		Date expiration = null;
		JWTClaimsSet claimsSet = getClaimsFromToken(token);
		expiration=claimsSet.getExpirationTime();
		return expiration;
	}

	@Override
	public String getUsernameFromToken(String token) {
		String username=null;
		try {
			JWTClaimsSet claims= getClaimsFromToken(token);
			username= claims.getStringClaim(USERNAME);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public byte[] generateShareSecret() {
		byte[] sharedSecret = new byte[32];
		sharedSecret = SECRET_KEY.getBytes();
		return sharedSecret;
	}

	@Override
	public Boolean isTokenExpired(String token) {
		Date expirationDate=getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}

	@Override
	public Boolean validateTokenLogin(String token) {
		if (token==null||token.trim().length()==0) {
			return false;
		}
		
		String username= getUsernameFromToken(token);
		if (username==null||username.isEmpty()) {
			return false;
		}
		
		if (isTokenExpired(token)) {
			return false;
		}
		return true;
	}
}
	

