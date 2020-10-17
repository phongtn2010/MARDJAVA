package com.vnsw.ws.p6.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p6.envelop.Envelope06;

public interface ReceiveService06 {

    Envelope06 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
