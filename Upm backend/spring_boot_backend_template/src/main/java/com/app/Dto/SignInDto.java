package com.app.Dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
	private String name;
	
	private String emailId;
	
	private String password;
	
	private String address;
	
	private String contactNo;
	
	private Role role;
}
