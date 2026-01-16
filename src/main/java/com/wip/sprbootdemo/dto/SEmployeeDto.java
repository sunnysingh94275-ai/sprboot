package com.wip.sprbootdemo.dto;

import org.springframework.hateoas.RepresentationModel;

public class SEmployeeDto extends RepresentationModel<SEmployeeDto>{

	private Long eid;
	private String ename;

	public SEmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SEmployeeDto(Long eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "SEmployeeDto [eid=" + eid + ", ename=" + ename + "]";
	}

}
