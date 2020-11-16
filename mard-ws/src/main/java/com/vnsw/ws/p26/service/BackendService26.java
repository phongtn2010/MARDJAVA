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

    ResponseJson phanHoiDonDK(ResponseWrapper responseWrapper);

    ResponseJson guiCVMienKiem(ResponseWrapper responseWrapper);

    ResponseJson thuHoiCVMienKiem(ResponseWrapper responseWrapper);
}