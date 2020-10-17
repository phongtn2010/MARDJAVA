package com.nsw.monre.p01.util;


public class ResponseMessage {

	private boolean success;
	private String status;
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
	@Override
	public String toString() {
		return "ResponseMessage [success=" + success + ", status=" + status + "]";
	}
	
}
