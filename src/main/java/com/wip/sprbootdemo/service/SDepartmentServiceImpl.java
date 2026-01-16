package com.wip.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.sprbootdemo.entity.SDepartment;
import com.wip.sprbootdemo.repository.SDepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SDepartmentServiceImpl implements SDepartmentService{

	@Autowired
	private SDepartmentRepository sDepartmentRepository;
	
	@Override
	public void createDepartment(SDepartment dept) {
	
		sDepartmentRepository.save(dept);
		System.out.println("Created " + dept.getDname() + "Successfully ");
	}

	@Override
	public List<SDepartment> getAllDepartments() {
	
		return sDepartmentRepository.findAll();
	}

	@Override
	public List<SDepartment> updateDepartment(SDepartment dept) {
		sDepartmentRepository.save(dept);
		return getAllDepartments();
	}

	@Override
	public List<SDepartment> deleteDepartment(Long did) {
		sDepartmentRepository.deleteById(did);
		return getAllDepartments();
	}

	@Override
	public Optional<SDepartment> getDepartmentById(Long did) {
		
		return sDepartmentRepository.findById(did);
	}

}
