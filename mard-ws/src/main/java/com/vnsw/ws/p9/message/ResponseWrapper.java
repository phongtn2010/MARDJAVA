package com.vnsw.ws.p9.message;

import com.vnsw.ws.p9.envelop.Header;

public class ResponseWrapper {
    private Header header;
    private Object data;

    public ResponseWrapper(Header header, Object data) {
        this.header = header;
        this.data = data;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
