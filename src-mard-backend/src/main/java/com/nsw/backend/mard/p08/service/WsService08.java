/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.service;

import com.nsw.backend.mard.p08.client.Header;
import com.nsw.backend.mard.p08.client.RequestEdit;
import com.nsw.backend.mard.p08.client.ResponseWrapper;
import com.nsw.backend.mard.p08.client.SendMessage;
import com.nsw.backend.mard.p08.exception.NSWException;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import com.nsw.backend.util.ResponseJson;

public interface WsService08 {
    ResponseJson sendProfile(Tbdhoso08 regProfile) throws NSWException;

    ResponseJson updateKqtd(ResponseWrapper request);

    ResponseJson updateKQXinRutHS(ResponseWrapper updateResult) throws NSWException;

    ResponseJson updateKQXinSuaHS(ResponseWrapper updateResult) throws NSWException;

    ResponseJson xlCVVSTY(ResponseWrapper request) throws NSWException;

    ResponseJson updateKDNK(ResponseWrapper request) throws NSWException;

    void internalStatusUpdate(Header header, String exactSenderName, long status, String... reason) throws NSWException;

    ResponseJson requestUpdateProfile(RequestEdit requestEdit);

    ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException;

    ResponseJson updateKQVSTY(ResponseWrapper responseWrapper) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;
}
