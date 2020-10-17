package com.vnsw.ws.p8.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p8.evelop.Envelope08;

public interface ReceiveService08 {

    Envelope08 receive(String xml);

    ResponseJson callResforEntity(String url, Object object, String method);
}
