package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.LoginDto;
import com.app.Dto.SignInDto;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.OwnerDao;
import com.app.dao.UserDao;
import com.app.entities.Owner;
import com.app.entities.Role;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OwnerDao ownerDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public User loginUser(LoginDto loginDto){
	    User user = userDao.findByEmailId(loginDto.getEmailId())
	            .orElseThrow(() -> new ResourceNotFoundException("Invalid EmailId!!"));
	    if (!(loginDto.getPassword()).equals(user.getPassword())){
	        throw new ResourceNotFoundException("Invalid Password !!!");
	    }
	    return user;
	}

	@Override
	public String signIn(SignInDto signDto) {
		System.out.println(signDto.getEmailId()+" "+signDto.getRole());
		if(signDto.getRole()==Role.USER)
			userDao.save(mapper.map(signDto,User.class));
		else
		if(signDto.getRole()==Role.OWNER)
			ownerDao.save(mapper.map(signDto, Owner.class));
		else
			throw new RuntimeException("SignIn unsuccessful");
		return "SignIn successful";
	}
	
	

}
