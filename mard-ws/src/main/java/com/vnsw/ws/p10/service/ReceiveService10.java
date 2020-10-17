package com.vnsw.ws.p10.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p10.envelop.Envelope10;

public interface ReceiveService10 {

    Envelope10 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
