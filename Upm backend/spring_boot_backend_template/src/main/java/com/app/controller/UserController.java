package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.ApiResponse;
import com.app.Dto.JWTResponse;
import com.app.Dto.LoginDto;
import com.app.Dto.SignInDto;
import com.app.entities.User;
import com.app.jwt_utils.JwtUtils;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager mgr;


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		User user = userService.loginUser(loginDto);
		Authentication authentication = mgr
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailId(),user.getPassword()));
		System.out.println("suj");
		String token = utils.generateJwtToken(authentication);
		System.out.println(token);
		System.out.println(user.getRole());
		return ResponseEntity.ok(new JWTResponse(token, "JWT Token Successful",user));
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody SignInDto signDto){
		String msg=userService.signIn(signDto);
		return ResponseEntity.ok(new ApiResponse(msg)); 
	}

}
