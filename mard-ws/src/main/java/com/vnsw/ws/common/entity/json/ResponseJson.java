package com.vnsw.ws.common.entity.json;

public class ResponseJson {

    private boolean success;
    private Object data;
    private Long total;
    public String message;

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

    public ResponseJson() {
    }

    public ResponseJson(boolean success, Object data, Long total, String message) {
        this.success = success;
        this.data = data;
        this.total = total;
        this.message = message;
    }
    
    public String toString(){
    	return "success=" + success +"|data="+ data + "|total=" + total + "|message=" + message;
    }
}
