package com.wip.sprbootdemo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class SEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;

	@Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
	@Pattern(regexp = "[^0-9]*", message = "Name must not contain Numbers")
	@NotBlank(message = "Name is mandatory field")
	private String ename;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory field")
	private String email;

	@Size(min = 5, message = "password must be 5 characters long")
	@NotBlank(message = "Password is mandatory field")
	private String password;

	@Past(message = "Date should be in Past")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@NotBlank(message = "Password is mandatory field")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be either Male or Female or Other")
	private String gender;

	@Pattern(regexp = "Admin|Employee", message = "Role must be either Admin or Employee")
	private String role;

	@ManyToOne
	@JoinColumn(name = "DEPTID")
	private SDepartment department;

	public SEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SEmployee(Long eid, String ename, String email, String password, LocalDate dob, String gender, String role) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public SDepartment getDepartment() {
		return department;
	}

	public void setDepartment(SDepartment department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "SEmployee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password + ", dob="
				+ dob + ", gender=" + gender + ", role=" + role + ", department=" + department + "]";
	}

}
