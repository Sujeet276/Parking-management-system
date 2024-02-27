package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.Dto.ApiResponse;
import com.app.Dto.FlatDto;
import com.app.entities.Owner;
import com.app.service.OwnerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/owner")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = { "Authorization", "Content-Type" })
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@GetMapping("/list")
	public ResponseEntity<?> ownerList() {
		return ResponseEntity.ok(ownerService.ownerList());
	}
	
	@PutMapping("/updateDetails")
	public ResponseEntity<?> updateOwner(@RequestBody Owner owner){
		return ResponseEntity.ok(ownerService.updateOwner(owner));
	}
	
	
	@GetMapping("/flatList")
	public ResponseEntity<?> flatList(){
		return ResponseEntity.ok(ownerService.flatList());
	}

	@GetMapping("/addImage/{id}")
	public ResponseEntity<?> setImage(@RequestParam("images") MultipartFile[] image, @PathVariable String id) {
		return ResponseEntity.ok(new ApiResponse(ownerService.addImage(image, Long.parseLong(id.substring(1,id.length()-1)))));
	}

	@PostMapping(value="/addFlat",consumes = "multipart/form-data")
	public ResponseEntity<?> addFlat(@RequestParam("flatNo") int flatNo, @RequestParam("floorNo") int floorNo,
			@RequestParam("type") String type,@RequestParam("address") String address, @RequestParam("images") MultipartFile[] image) {
		FlatDto flatDto=new FlatDto(flatNo,floorNo,type,address);
		return ResponseEntity.ok(new ApiResponse(ownerService.addFlat(flatDto,image)));
	}
	
	@GetMapping(value="/getImage/{id}")
	public ResponseEntity<?> getImage(@PathVariable String id){
		System.out.println("path variable: "+id);
		return ResponseEntity.ok(ownerService.getImage(Long.parseLong(id.substring(1,id.length()-1))));
	}
}
