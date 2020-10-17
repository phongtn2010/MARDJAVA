/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p10.entity.json.RegistrationConfirm;
import com.vnsw.ws.p10.message.receive.AnimalIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalProcessed;
import com.vnsw.ws.p10.message.receive.AnimalProductsIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.FoodAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.ProcessVSTYList;
import com.vnsw.ws.p10.message.receive.ProductAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.QuarantineCancelResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineFee;
import com.vnsw.ws.p10.message.receive.QuarantineFeeResponse;
import com.vnsw.ws.p10.message.receive.QuarantineResult;
import java.util.List;


public interface BackendService10 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson updateHoSoStatus(String fiMaHoso, Long fiTrangthai, String fiLydo);
    ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo, Long loaiGCN);
    ResponseJson updateLichSuSend(String fiMaHoso, Long fiTrangthai);
    ResponseJson updateKqtd(QuarantineResult result);
    ResponseJson updateXacNhanDon(List<RegistrationConfirm> lstConfirm);
    ResponseJson updateKQXinRutHS(QuarantineCancelResponse response);
    ResponseJson updateKQXinSuaHS(QuarantineEditResponse response);
    ResponseJson tbApPhi(QuarantineFee feeNotice);
    ResponseJson tbApPhiBoSung(QuarantineFeeResponse feeResponse);
    ResponseJson lohangcanXL(AnimalProcessed animalProcessed);
    ResponseJson XLMau9(ProcessVSTYList processVSTYList);
    ResponseJson XLMau14A(AnimalIsolationList animalIsolationList);
    ResponseJson XLMau14B(AnimalProductsIsolationList animalProductsIsolationList);
    ResponseJson XLMau15A(AnimalQuarantineList animalQuarantineList);
    ResponseJson XLMau15B(ProductAnimalQuarantineList productAnimalQuarantineList);
    ResponseJson XLMau15C(FoodAnimalQuarantineList foodAnimalQuarantineList);
    ResponseJson updateKQXinSuaGCN(QuarantineCerEditResponse response);
}