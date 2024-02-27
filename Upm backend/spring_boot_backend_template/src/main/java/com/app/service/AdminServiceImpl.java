package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDao;
import com.app.entities.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String addAdmin(Admin admin) {
		adminDao.save(admin);
		return "Details inserted Successfully";
	}

	@Override
	public String removeAdmin(int id) {
		adminDao.deleteById(id);
		return "Admin Deleted Successfully";
	}
	
}
