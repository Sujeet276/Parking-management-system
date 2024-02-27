package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.ApiResponse;
import com.app.entities.Admin;
import com.app.service.AdminService;

@RequestMapping("/admin")
@RestController
@CrossOrigin( methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, 
allowedHeaders = {"Authorization", "Content-Type"})
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
		return ResponseEntity.ok(new ApiResponse(service.addAdmin(admin)));
	}
	
	@PostMapping("/remove/{id}")
	public ResponseEntity<?> removeAdmin(@PathVariable int id){
		return ResponseEntity.ok(new ApiResponse(service.removeAdmin(id)));
	}
	
	
}
