package com.vnsw.ws.p6.message;

import com.vnsw.ws.p6.envelop.Header06;

public class ResponseWrapper {
    private Header06 header;
    private Object data;

    public ResponseWrapper(Header06 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header06 getHeader() {
        return header;
    }

    public void setHeader(Header06 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
