package com.interview.task.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtility {
	
	private String key = "itssecret";
	
	private int refreshExpirationDateInMs=9000000;

	public static final long JWT_TOKEN_VALIDITY = 1 * 60 * 15;

	public String generateToken(String mobileNumber) {
		Map<String, Object> claims = new HashMap<>();
		
		return doGenerateToken(claims,mobileNumber);
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, key).compact();
	}
	
	public String generateRefreshToken(String subject) {
		
		Map<String, Object> claims = new HashMap<>();
		
		return doGenerateRefreshToken(claims,subject);
		
	}
	
	public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
				.signWith(SignatureAlgorithm.HS512, key).compact();

	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}


	public String parseToken(String token) {
		String phonenumber=null;
		

		if (token != null && token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			try {
				phonenumber = getUsernameFromToken(jwtToken);
				return phonenumber;
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
				e.printStackTrace();
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("JWT Token does not begin with Bearer String");
		}

		return phonenumber;

	}

}
