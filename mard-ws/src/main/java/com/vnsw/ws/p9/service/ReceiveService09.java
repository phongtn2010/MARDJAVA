package com.vnsw.ws.p9.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p9.envelop.Envelope09;

public interface ReceiveService09 {

    Envelope09 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
