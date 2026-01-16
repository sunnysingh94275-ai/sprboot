package com.wip.sprbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.sprbootdemo.entity.SDepartment;

@Repository
public interface SDepartmentRepository extends JpaRepository<SDepartment, Long>{
	
}
