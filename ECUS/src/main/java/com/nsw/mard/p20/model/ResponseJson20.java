package com.nsw.mard.p20.model;

public class ResponseJson20 {
	private boolean success;
	private Object data;
	private Long total;
	private String message;
	private int status;
	private String gatewayMessage;
	private String exception;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
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
	
	public String getGatewayMessage() {
		return gatewayMessage;
	}

	public void setGatewayMessage(String gatewayMessage) {
		this.gatewayMessage = gatewayMessage;
	}

	public ResponseJson20() {
	}

	public ResponseJson20(boolean success, Object data, Long total, String message) {
		this.success = success;
		this.data = data;
		this.total = total;
		this.message = message;
	}

	public ResponseJson20(boolean success, Object data, Long total, String message, int status) {
		this.success = success;
		this.data = data;
		this.total = total;
		this.message = message;
		this.status = status;
	}


   
    
}
