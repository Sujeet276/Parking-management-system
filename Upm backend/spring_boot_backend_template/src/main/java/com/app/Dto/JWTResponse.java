package com.app.Dto;

import com.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JWTResponse {

	private String token;
	
	private String msg;
	
	private User user;
}
