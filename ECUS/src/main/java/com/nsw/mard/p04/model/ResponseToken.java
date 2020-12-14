package com.nsw.mard.p04.model;

public class ResponseToken
{
    private boolean status;
    private int error;
    private String message;
    private String token;
    
    public Boolean getStatus() {
        return this.status;
    }
    
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(final boolean status) {
        this.status = status;
    }
    
    public int getError() {
        return this.error;
    }
    
    public void setError(final int error) {
        this.error = error;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
}