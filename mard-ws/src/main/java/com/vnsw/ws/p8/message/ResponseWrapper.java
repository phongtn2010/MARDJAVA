package com.vnsw.ws.p8.message;

import com.vnsw.ws.p8.evelop.Header08;

public class ResponseWrapper {
    private Header08 header;
    private Object data;

    public ResponseWrapper(Header08 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header08 getHeader() {
        return header;
    }

    public void setHeader(Header08 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
