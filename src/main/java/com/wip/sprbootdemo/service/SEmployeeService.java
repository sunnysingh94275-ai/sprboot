package com.wip.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wip.sprbootdemo.dto.SEmployeeDto;
import com.wip.sprbootdemo.entity.SEmployee;

public interface SEmployeeService {
	public void createEmployee(SEmployee employee);
	public List<SEmployee> getAllEmployee();
	public List<SEmployee> updateEmployee(SEmployee employee);
	public List<SEmployee> deleteEmployee(Long eid);
	public Optional<SEmployee> getEmployeeById(Long eid);
	public SEmployee getEmpByEname(String name);
	public List<SEmployee> getEmpByEnameContains(String name);
	public void uploadAllEmployees(List<SEmployee> emplist);
	public Page<SEmployee> getAllEmployees(Pageable pageable);
	public Optional<SEmployee> getEmployeeForHateoas(Long eid);
	
}
