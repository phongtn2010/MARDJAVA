/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p04.envelop.Envelope;

public interface ReceiveService04 {
    Envelope receive(String xml); 
    ResponseJson  callResforEntity(String url, Object object, String method);
}
