package com.capgemini.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.service.LoginService;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/Admin/{username}/{password}")
	public ResponseEntity<Boolean> adminLogin(@PathVariable String username,@PathVariable String password)
	{
		return ResponseEntity.ok(loginService.adminLogin(username, password));
	}
	
	@GetMapping("/Faculty/{username}/{password}")
	public ResponseEntity<Boolean> facultyLogin(@PathVariable String username,@PathVariable String password) throws RecordNotFoundException
	{
		return ResponseEntity.ok(loginService.facultyLogin(username, password));
	}
	@PostMapping("/user")
	public ResponseEntity<Boolean> login(@RequestBody HashMap<String,String> loginData) {
		String username = loginData.getOrDefault("username","");
		String pwd = loginData.getOrDefault("password","");
		String userType = loginData.getOrDefault("userType","");
		if(userType.equals("admin")) {
			return ResponseEntity.ok(loginService.adminLogin(username, pwd));
		} else {
			return ResponseEntity.ok(loginService.facultyLogin(username, pwd));

		}
	}
}
