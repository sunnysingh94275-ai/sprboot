package com.wip.sprbootdemo.exception;

public class ApiError {
	private String message;
    private int status;
	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiError(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiError [message=" + message + ", status=" + status + "]";
	}
    
    
}
