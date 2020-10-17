package com.vnsw.ws.p7.message;

import com.vnsw.ws.p7.evelope.Header07;
import lombok.Data;

@Data
public class ResponseWrapper {
    private Header07 header;
    private Object data;

    public ResponseWrapper(Header07 header, Object data) {
        this.header = header;
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public Header07 getHeader() {
        return header;
    }

    public void setHeader(Header07 header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
