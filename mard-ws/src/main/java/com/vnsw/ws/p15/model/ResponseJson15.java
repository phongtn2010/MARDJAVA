package com.vnsw.ws.p15.model;

public class ResponseJson15 {
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


	
	public String toString() {
		return "success=" + success + "|data=" + data + "|total=" + total + "|message=" + message;
	}
}
