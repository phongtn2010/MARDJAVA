package com.vnsw.ws.p26.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p26.envelop.Envelope26;

public interface ReceiveService26 {

    Envelope26 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
