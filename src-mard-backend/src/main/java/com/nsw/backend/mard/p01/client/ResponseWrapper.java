package com.nsw.backend.mard.p01.client;

import lombok.Data;

@Data
public class ResponseWrapper {
    private Header header;
    private Object data;
}
