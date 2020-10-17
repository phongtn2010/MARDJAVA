package com.nsw.backend.mard.p25.client;

import lombok.Data;

@Data
public class ResponseWrapper {
    private Header header;
    private Object data;
}
