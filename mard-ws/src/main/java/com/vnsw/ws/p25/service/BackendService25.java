/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p25.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p25.message.ResponseWrapper;


public interface BackendService25 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson xacNhanDon(ResponseWrapper responseWrapper);
    ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper);
    ResponseJson ketQuaXuLy(ResponseWrapper responseWrapper);
}