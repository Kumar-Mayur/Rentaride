package com.rentaride.Registerlogin.Response;

import java.util.function.BooleanSupplier;

public class LoginResponse {
	
	String message;
	Boolean status;
	
	
	public LoginResponse(String message, Boolean string) {
		super();
		this.message = message;
		this.status = string;
	}
	
	public LoginResponse() {
		
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", status=" + status + "]";
	}

	public BooleanSupplier isSuccess() {
		// TODO Auto-generated method stub
		return null;
	}

}
