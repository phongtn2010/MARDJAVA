package com.vnsw.ws.p7.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p7.message.ResponseWrapper;

public interface BackendService07 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson updateKQTD(ResponseWrapper responseWrapper);
    ResponseJson updateXacNhanDonDangKy(ResponseWrapper responseWrapper);
    ResponseJson updateKetquaXinSuaHoso(ResponseWrapper responseWrapper);
    ResponseJson updateKetquaXinRutHoso(ResponseWrapper responseWrapper);
    ResponseJson updateThongbaoApphi(ResponseWrapper responseWrapper);
    ResponseJson updateXacnhanPhi(ResponseWrapper responseWrapper);
    ResponseJson updateThongbaoLohangKhongdat(ResponseWrapper responseWrapper);
    ResponseJson updateCNVC(ResponseWrapper responseWrapper);
    ResponseJson updateCNKD(ResponseWrapper responseWrapper);
    ResponseJson updateTuchoiXinsuaGCN(ResponseWrapper responseWrapper);
}
