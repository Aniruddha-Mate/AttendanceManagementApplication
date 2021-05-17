package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AdminEntity;
import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.RecordNotFoundException;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Override
	public boolean adminLogin(String username, String password) 
	{
//		String detail="username not exist. Please register !!!!";
		boolean detail = false;
		List<AdminEntity> admins=adminService.getAllAdmin();
		for(AdminEntity admin:admins)
		{
			if(admin.getUsername().equals(username) && admin.getPassword().equals(password))
			{
				detail=true;break;
			}
			else if(admin.getUsername().equals(username) && admin.getPassword()!=password)
			{
				detail=false;break;
			}
		}
		return detail;
	}

	@Override
	public boolean facultyLogin(String username, String password) { 
		
//		String detail="username not exist. Please register !!!!";
		boolean detail=false;
		try {
			List<FacultyEntity> faculties= facultyService.getAllFaculty();
			for(FacultyEntity faculty:faculties)
			{
				if(faculty.getUserName().equals(username) && faculty.getPassword().equals(password))
				{
					detail=true;
					break;
				}
				else if(faculty.getUserName().equals(username) && faculty.getPassword()!=password)
				{
					detail=false;
					break;
				}
				
			}
		}catch(Exception ex) {}
		
		return detail;
	}

	
}
