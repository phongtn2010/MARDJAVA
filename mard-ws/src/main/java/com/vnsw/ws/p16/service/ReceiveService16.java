package com.vnsw.ws.p16.service;

import com.vnsw.ws.p16.envelop.Envelope;

public interface ReceiveService16 {

    Envelope receive(String xml);

}
