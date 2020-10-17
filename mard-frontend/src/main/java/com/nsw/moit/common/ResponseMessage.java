package com.nsw.moit.common;


public class ResponseMessage {

	private boolean success;
	private String status;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseMessage [success=" + success + ", status=" + status + ", message=" + message + "]";
	}
	
	
	
	
}
