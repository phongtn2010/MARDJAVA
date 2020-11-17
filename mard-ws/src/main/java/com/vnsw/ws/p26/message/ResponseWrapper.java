package com.vnsw.ws.p26.message;

import com.vnsw.ws.p26.envelop.Header26;

public class ResponseWrapper {
    private Header26 header;
    private Object data;

    public ResponseWrapper(Header26 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header26 getHeader() {
        return header;
    }

    public void setHeader(Header26 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
