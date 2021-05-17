package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AdminEntity;

import com.capgemini.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public AdminEntity updateAdminById(int id, AdminEntity entity) {
		
		AdminEntity adminEntity = adminRepository.findById(id).orElse(null);
		adminEntity.setUsername(entity.getUsername());
		adminEntity.setPassword(entity.getPassword());
		adminRepository.save(adminEntity);
		return adminEntity;
	}

	@Override
	public List<AdminEntity> getAllAdmin() {
		
		List<AdminEntity> adminList = new ArrayList<>();
		adminList = adminRepository.findAll();
		
		return adminList;
	}

	@Override
	public AdminEntity addAdmin(@Valid AdminEntity entity) {
		AdminEntity fe = adminRepository.save(entity);
		return fe;
	}
	
	
	
}
