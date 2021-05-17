package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.AdminEntity;
import com.capgemini.entity.FacultyEntity;
import com.capgemini.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path="/addAdmin")
	public ResponseEntity<AdminEntity> addAdmin(@Valid @RequestBody AdminEntity se)
	{
		AdminEntity se1 = adminService.addAdmin(se);
		
		return new ResponseEntity<AdminEntity>(se1,HttpStatus.CREATED);
	}
	
	
	@GetMapping(path="/getAdmin")
	public ResponseEntity<List<AdminEntity>> getAllAdmin(){
		
		List<AdminEntity> adminList = adminService.getAllAdmin();
		return new ResponseEntity<List<AdminEntity>>(adminList, HttpStatus.FOUND);
	}
	
	@PutMapping(path="/updateAdmin/{id}")
	public ResponseEntity<AdminEntity> updateAdmin(@Valid @PathVariable int id, @Valid @RequestBody AdminEntity entity){
		
		AdminEntity re = adminService.updateAdminById(id, entity);
		return new ResponseEntity<AdminEntity>(re, HttpStatus.ACCEPTED);
		
	}
	
}
