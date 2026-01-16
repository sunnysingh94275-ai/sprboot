package com.wip.sprbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import com.wip.sprbootdemo.dto.SEmployeeDto;
import com.wip.sprbootdemo.entity.SEmployee;
import com.wip.sprbootdemo.exception.EmployeeNotFoundException;
import com.wip.sprbootdemo.service.SEmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class SEmployeeRestController {

	@Autowired
	private SEmployeeService sEmployeeService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello All";
	}

	@PostMapping("/createEmp")
	public ResponseEntity<?> addEmployee(@RequestBody SEmployee employee) {
		sEmployeeService.createEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/allEmp")
	public ResponseEntity<List<SEmployee>> listAllEmployees() {
		List<SEmployee> emplist = sEmployeeService.getAllEmployee();
		return new ResponseEntity<List<SEmployee>>(emplist, HttpStatus.OK);

	}

	@PutMapping("/updateEmp")
	public ResponseEntity<List<SEmployee>> updateEmployee(@RequestBody SEmployee employee) {
		List<SEmployee> emplist = sEmployeeService.updateEmployee(employee);
		return new ResponseEntity<List<SEmployee>>(emplist, HttpStatus.OK);

	}

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<List<SEmployee>> deleteEmployee(@PathVariable("id") Long eid) {
		List<SEmployee> emplist = sEmployeeService.deleteEmployee(eid);
		return new ResponseEntity<List<SEmployee>>(emplist, HttpStatus.OK);
	}

	@GetMapping("/getAEmp/{eid}")
	public ResponseEntity<SEmployee> getEmployeeById(@PathVariable("eid") Long eid) {
		Optional<SEmployee> emp = sEmployeeService.getEmployeeById(eid);
		if (!emp.isPresent()) {
			// return new ResponseEntity<HEmployee>(HttpStatus.NO_CONTENT);
			throw new EmployeeNotFoundException("Employee", "EID", eid);

		}
		SEmployee semp = emp.get();
		return new ResponseEntity<SEmployee>(semp, HttpStatus.OK);
	}

	@GetMapping("/getAEmpByname/{name}")
	public ResponseEntity<SEmployee> getEmpByEname(@PathVariable("name") String name) {
		SEmployee emp = sEmployeeService.getEmpByEname(name);
		System.out.println("Name  " + emp + name);
		return new ResponseEntity<SEmployee>(emp, HttpStatus.OK);
	}

	@GetMapping("/getEmpBynameContains/{name}")
	public ResponseEntity<List<SEmployee>> getEmpByEnameContains(@PathVariable("name") String name) {
		List<SEmployee> emp = sEmployeeService.getEmpByEnameContains(name);
		System.out.println("Name  " + emp + name);
		return new ResponseEntity<List<SEmployee>>(emp, HttpStatus.OK);
	}

	// Bulk Insert
	@PostMapping("/bulkupload")
	public ResponseEntity<String> bulkuploadEmployees(@RequestBody List<SEmployee> emplist) {
		sEmployeeService.uploadAllEmployees(emplist);
		return new ResponseEntity<String>("ALL Employees uploaded Successfully" + emplist.size(), HttpStatus.CREATED);
	}

	@GetMapping("/listAll")
	public ResponseEntity<Page<SEmployee>> getAllEmployees(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "eid") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<SEmployee> emplist = sEmployeeService.getAllEmployees(pageable);
		return new ResponseEntity<Page<SEmployee>>(emplist, HttpStatus.OK);

	}

	@GetMapping("/hateoas/{id}")
	public SEmployeeDto getEmployeeForHateoas(@PathVariable Long id) {
		SEmployee emp = sEmployeeService.getEmployeeForHateoas(id).orElseThrow();

		SEmployeeDto empDto = new SEmployeeDto();
		empDto.setEid(emp.getEid());
		empDto.setEname(emp.getEname());
		System.out.println(empDto);
		
		
		//EntityModel<SEmployeeDto> model = EntityModel.of(empDto);
		empDto.add(linkTo(methodOn(SEmployeeRestController.class).getAllEmp()).withSelfRel());
		empDto.add(linkTo(methodOn(SEmployeeRestController.class).getEmployeeById(id)).withSelfRel());
		empDto.add(linkTo(methodOn(SEmployeeRestController.class).getEmpByEname(empDto.getEname())).withSelfRel());
		
		//return model;*/
		return empDto;
	}
	@GetMapping
	public List<SEmployee> getAllEmp() {
		return sEmployeeService.getAllEmployee();
	}
}
