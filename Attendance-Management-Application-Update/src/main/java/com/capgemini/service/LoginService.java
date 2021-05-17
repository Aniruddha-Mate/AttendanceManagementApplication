package com.capgemini.service;

import com.capgemini.exception.RecordNotFoundException;

public interface LoginService 
{
	boolean adminLogin(String username,String password);
	boolean facultyLogin(String username,String password);
	
}
