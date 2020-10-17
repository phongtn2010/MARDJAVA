package com.vnsw.ws.p7.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p7.evelope.Envelope07;

public interface ReceiveService07 {

    Envelope07 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
