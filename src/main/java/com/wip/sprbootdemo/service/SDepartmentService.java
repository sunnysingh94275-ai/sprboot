package com.wip.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import com.wip.sprbootdemo.entity.SDepartment;

public interface SDepartmentService {
	public void createDepartment(SDepartment dept);
	public List<SDepartment> getAllDepartments();
	public List<SDepartment> updateDepartment(SDepartment dept);
	public List<SDepartment> deleteDepartment(Long did);
	public Optional<SDepartment> getDepartmentById(Long did);
}
