package com.nsw.backend.model.JSON;

public class RequestJson {
    private String token;
    private String data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RequestJson() {
    }
}
