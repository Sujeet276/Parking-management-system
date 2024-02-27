package com.app.service;

import com.app.Dto.ApiResponse;
import com.app.entities.Admin;

public interface AdminService {

	public String addAdmin(Admin admin);
	
	public String removeAdmin(int id);
	
}
