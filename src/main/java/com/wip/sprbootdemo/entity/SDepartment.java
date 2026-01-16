package com.wip.sprbootdemo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	private String dname;
	
	@OneToMany(mappedBy = "department" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<SEmployee> employee;
	
	public SDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SDepartment(Long deptId, String dname) {
		super();
		this.deptId = deptId;
		this.dname = dname;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
//	public List<SEmployee> getEmployee() {
//		return employee;
//	}
//	public void setEmployee(List<SEmployee> employee) {
//		this.employee = employee;
//	}
	@Override
	public String toString() {
		return "SDepartment [deptId=" + deptId + ", dname=" + dname + "]";
	}
		
}
