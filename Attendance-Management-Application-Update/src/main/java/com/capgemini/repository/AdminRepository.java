package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{
	
}
