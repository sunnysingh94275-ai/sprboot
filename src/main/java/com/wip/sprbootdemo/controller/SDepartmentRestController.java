package com.wip.sprbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wip.sprbootdemo.entity.SDepartment;
import com.wip.sprbootdemo.entity.SEmployee;
import com.wip.sprbootdemo.exception.DepartmentNotFoundException;
import com.wip.sprbootdemo.service.SDepartmentService;

@RestController
@RequestMapping("/api/v1/department")
public class SDepartmentRestController {
	@Autowired
	private SDepartmentService sDepartmentService;
	
	@PostMapping("/createDept")
	public ResponseEntity<?> addDepartment(@RequestBody SDepartment dept) {
		sDepartmentService.createDepartment(dept);
		return new ResponseEntity<>(dept, HttpStatus.CREATED);
	}

	@GetMapping("/allDept")
	public ResponseEntity<List<SDepartment>> listAllDepartments() {
		List<SDepartment> deptlist = sDepartmentService.getAllDepartments();
		return new ResponseEntity<List<SDepartment>>(deptlist, HttpStatus.OK);

	}

	@PutMapping("/updateDept")
	public ResponseEntity<List<SDepartment>> updateDepartment(@RequestBody SDepartment dept) {
		List<SDepartment> deptlist = sDepartmentService.updateDepartment(dept);
		return new ResponseEntity<List<SDepartment>>(deptlist, HttpStatus.OK);

	}

	@DeleteMapping("/deleteDept/{id}")
	public ResponseEntity<List<SDepartment>> deleteDepartment(@PathVariable("id") Long did) {
		List<SDepartment> deptlist = sDepartmentService.deleteDepartment(did);
		return new ResponseEntity<List<SDepartment>>(deptlist, HttpStatus.OK);
	}

	@GetMapping("/getADept/{did}")
	public ResponseEntity<SDepartment> getDepartmentById(@PathVariable("did") Long did) {
		Optional<SDepartment> dept = sDepartmentService.getDepartmentById(did);
		if (!dept.isPresent()) {
			
			throw new DepartmentNotFoundException("Department", "DeptID", did);

		}
		SDepartment sdept = dept.get();
		return new ResponseEntity<SDepartment>(sdept, HttpStatus.OK);
	}
	
	
}
