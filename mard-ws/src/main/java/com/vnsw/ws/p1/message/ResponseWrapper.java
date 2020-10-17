package com.vnsw.ws.p1.message;


import com.vnsw.ws.p1.evelop.Header01;

public class ResponseWrapper {
    private Header01 header;
    private Object data;

    public ResponseWrapper(Header01 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header01 getHeader() {
        return header;
    }

    public void setHeader(Header01 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
