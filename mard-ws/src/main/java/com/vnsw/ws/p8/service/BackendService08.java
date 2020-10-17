/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p8.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p8.message.ResponseWrapper;


public interface BackendService08 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson ketquaThamdinh(ResponseWrapper responseWrapper);
    ResponseJson yeucauSuadoiBosung(ResponseWrapper responseWrapper);
    ResponseJson yeucauRutHS(ResponseWrapper responseWrapper);
    ResponseJson tuchoiYeucauRutHS(ResponseWrapper responseWrapper);
    ResponseJson dongyYeuCauRutHS(ResponseWrapper responseWrapper);
    ResponseJson tuchoiYeuCauRutHS(ResponseWrapper responseWrapper);
    ResponseJson congvanVSTY(ResponseWrapper responseWrapper);
    ResponseJson congvanKDNK(ResponseWrapper responseWrapper);
    ResponseJson suaCongvanKDNK(ResponseWrapper responseWrapper);
    ResponseJson ketquaVSTYKhongdat(ResponseWrapper responseWrapper);
    ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper);
    ResponseJson phanhoiYeucauRutHoso(ResponseWrapper responseWrapper);

}