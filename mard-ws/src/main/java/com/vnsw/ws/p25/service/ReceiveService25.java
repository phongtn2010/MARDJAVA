package com.vnsw.ws.p25.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p25.envelop.Envelope25;

public interface ReceiveService25 {

    Envelope25 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
