package com.nsw.backend.mard.p09.client;

import lombok.Data;

@Data
public class ResponseWrapper {
    private Header header;
    private Object data;
}
