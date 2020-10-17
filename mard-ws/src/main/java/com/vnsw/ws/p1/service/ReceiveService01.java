package com.vnsw.ws.p1.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p1.evelop.Envelope01;

public interface ReceiveService01 {
    Envelope01 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
