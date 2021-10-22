package com.example.demo.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.service.auth.MyUserPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	@Value("${xxx.app.jwtSecret}")
	private String jwtSecret;

	@Value("${xxx.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtTocken(Authentication authentication) {
		MyUserPrincipal userPrincipal = (MyUserPrincipal) authentication.getPrincipal();

		Date date = new Date();
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(date)
				.setExpiration(new Date(date.getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtTocken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtTocken(String authenToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authenToken);
			return true;

		} catch (SignatureException e) {
			System.err.println("Invalid JWT signature: " + e.toString());
		} catch (MalformedJwtException e) {
			System.err.println("Invalid JWT token: " + e.toString());
		} catch (ExpiredJwtException e) {
			System.err.println("JWT token is expired: " + e.toString());
		} catch (UnsupportedJwtException e) {
			System.err.println("JWT token is unsupported: " + e.toString());
		} catch (IllegalArgumentException e) {
			System.err.println("JWT claims string is empty: " + e.toString());
		}
		return false;
	}
}
