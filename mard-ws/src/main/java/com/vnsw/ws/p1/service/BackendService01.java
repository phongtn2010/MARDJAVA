package com.vnsw.ws.p1.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p1.evelop.Header01;
import com.vnsw.ws.p1.message.ResponseWrapper;

public interface BackendService01 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson updateHoSoStatus(Header01 header, String fiMaHoso, Long fiTrangthai, String fiLydo);
    ResponseJson updateKQTDhoso01(ResponseWrapper responseWrapper);
    ResponseJson updateTBDYhoso01(ResponseWrapper responseWrapper);
    ResponseJson updateKQYCSuaHoSo01(ResponseWrapper responseWrapper);
    ResponseJson updateKQYCRutHoSo01(ResponseWrapper responseWrapper);
    ResponseJson updateTBApPhi01(ResponseWrapper responseWrapper);
    ResponseJson updateTBXacNhanPhi01(ResponseWrapper responseWrapper);
    ResponseJson updateCVKQYCXuatKhau01(ResponseWrapper responseWrapper);
    ResponseJson updateTBKQYCHuyCNKD(ResponseWrapper responseWrapper);
    ResponseJson updateTBKQYCSuaCNKD(ResponseWrapper responseWrapper);
    ResponseJson updateCNKD13A(ResponseWrapper responseWrapper);
    ResponseJson updateCNKD13B(ResponseWrapper responseWrapper);
    ResponseJson updateCNKDChina(ResponseWrapper responseWrapper);
    ResponseJson updateCNKDHongKongChicken(ResponseWrapper responseWrapper);
    ResponseJson updateCNKDHongKongPig(ResponseWrapper responseWrapper);
    ResponseJson updateCNKDMalaysia(ResponseWrapper responseWrapper);
}
