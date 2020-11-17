package com.nsw.backend.mard.p26.client;

import com.nsw.backend.mard.p26.client.Header;
import lombok.Data;

@Data
public class ResponseWrapper {
    private Header header;
    private Object data;
}
