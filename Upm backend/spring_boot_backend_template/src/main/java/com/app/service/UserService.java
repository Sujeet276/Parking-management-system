package com.app.service;

import com.app.Dto.LoginDto;
import com.app.Dto.SignInDto;
import com.app.entities.User;

public interface UserService {
	
	public User loginUser(LoginDto loginDto);

	public String signIn(SignInDto signDto);

}
