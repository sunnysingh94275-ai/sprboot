package com.wip.sprbootdemo.exception;

public class DepartmentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String resourceName;
	String field;
	String fieldName;
	Long fieldId;

	public DepartmentNotFoundException() {
	}

	public DepartmentNotFoundException(String resourceName, String field, Long fieldId) {
		super(String.format("%s not found with %s : %d", resourceName, field, fieldId));

		this.resourceName = resourceName;
		this.field = field;
		this.fieldId = fieldId;
	}
}
