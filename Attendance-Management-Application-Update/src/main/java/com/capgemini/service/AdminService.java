package com.capgemini.service;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.entity.AdminEntity;

public interface AdminService {
	
	AdminEntity updateAdminById(int id, AdminEntity entity);
	
	List<AdminEntity> getAllAdmin();

	AdminEntity addAdmin(AdminEntity entity);

}
