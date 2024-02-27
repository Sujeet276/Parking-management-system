package com.app.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.jwt_utils.JwtUtils;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtils utils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeadr = request.getHeader("Authorization");
		if (authHeadr != null && authHeadr.startsWith("Bearer")) {
			
			System.out.println("got bearer token");
			
			String token = authHeadr.substring(7);
			
			Claims claims = utils.validateJwtToken(token);
			
			String email = utils.getUserNameFromJwtToken(claims);
			List<GrantedAuthority> authorities = utils.getAuthoritiesFromClaims(claims);
			System.out.println("authorities: "+authorities.toString());
			UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(email, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} 
		
		filterChain.doFilter(request, response);
		
	}

}
