package com.vnsw.ws.p01.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p01.envelop.Envelope;

public interface ReceiveService1 {
	Envelope receive(String xml); 
	ResponseJson  callResforEntity(String url, Object object, String method);
}
