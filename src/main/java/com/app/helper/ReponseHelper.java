package com.app.helper;

public class ReponseHelper {
	
	private boolean status;
	private String message;
	
	public ReponseHelper(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public static ReponseHelper setSuccessMessage(String message) {
		return new ReponseHelper(true, message);
	}
	
	public static ReponseHelper setErrorMessage(String message) {
		return new ReponseHelper(false, message);
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
