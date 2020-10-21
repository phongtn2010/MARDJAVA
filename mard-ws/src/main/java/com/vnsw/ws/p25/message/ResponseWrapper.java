package com.vnsw.ws.p25.message;

import com.vnsw.ws.p25.envelop.Header25;

public class ResponseWrapper {
    private Header25 header;
    private Object data;

    public ResponseWrapper(Header25 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header25 getHeader() {
        return header;
    }

    public void setHeader(Header25 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
