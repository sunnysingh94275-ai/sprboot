package com.wip.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wip.sprbootdemo.dto.SEmployeeDto;
import com.wip.sprbootdemo.entity.SDepartment;
import com.wip.sprbootdemo.entity.SEmployee;
import com.wip.sprbootdemo.repository.SEmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SEmployeeServiceImpl implements SEmployeeService {

	@Autowired
	private SEmployeeRepository sEmployeeRepository;

	@Override
	public void createEmployee(SEmployee employee) {

		sEmployeeRepository.save(employee);
		System.out.println("Created " + employee.getEname() + "Successfully ");
	}

	@Override
	public List<SEmployee> getAllEmployee() {

		return sEmployeeRepository.findAll();
	}

	@Override
	public List<SEmployee> updateEmployee(SEmployee employee) {

		sEmployeeRepository.save(employee);
		return getAllEmployee();
	}

	@Override
	public List<SEmployee> deleteEmployee(Long eid) {
		sEmployeeRepository.deleteById(eid);
		return getAllEmployee();
	}

	@Override
	public Optional<SEmployee> getEmployeeById(Long eid) {

		return sEmployeeRepository.findById(eid);
	}

	@Override
	public SEmployee getEmpByEname(String name) {

		return sEmployeeRepository.findByEname(name);
	}

	@Override
	public List<SEmployee> getEmpByEnameContains(String name) {

		return sEmployeeRepository.findByEnameContaining(name);
	}

	@Override
	public void uploadAllEmployees(List<SEmployee> emplist) {
		for (SEmployee emp : emplist) {

			if (emp.getDepartment() != null && emp.getDepartment().getDeptId() != null) {
				SDepartment dept = new SDepartment();
				dept.setDeptId(emp.getDepartment().getDeptId());
				emp.setDepartment(dept);
			}
			sEmployeeRepository.saveAll(emplist);

		}

	}

	@Override
	public Page<SEmployee> getAllEmployees(Pageable pageable) {
		return sEmployeeRepository.findAll(pageable);
	}

	@Override
	public Optional<SEmployee> getEmployeeForHateoas(Long eid) {
		return sEmployeeRepository.findById(eid);
	}

}
