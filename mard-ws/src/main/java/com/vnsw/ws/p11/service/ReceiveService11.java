package com.vnsw.ws.p11.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p11.envelop.Envelope11;

public interface ReceiveService11 {

    Envelope11 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
