/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p26.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p26.message.ResponseWrapper;


public interface BackendService26 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson xacNhanDon(ResponseWrapper responseWrapper);
    ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper);
    ResponseJson ketQuaXuLy(ResponseWrapper responseWrapper);
    ResponseJson thuHoiGDK(ResponseWrapper responseWrapper);

    ResponseJson tccdGuiKQKT(ResponseWrapper responseWrapper);

    ResponseJson xuLyKQ(ResponseWrapper responseWrapper);

    ResponseJson giayXNCL(ResponseWrapper responseWrapper);

    ResponseJson thuHoiGiayXNCL(ResponseWrapper responseWrapper);

    ResponseJson tiepNhanHD2D(ResponseWrapper responseWrapper);

}