package com.luan.apiusuarios.security;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
	
	private static final String SECRET ="segredo-super-seguro";
	private static final long EXPIRATION = 1000 * 60 * 60 * 2;//2h
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
	}
	
	public String getEmail(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean isValid(String token) {
		try {
			getEmail(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
}
