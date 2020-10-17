/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p11.entity.json.RegistrationConfirm;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCerInfoRequest;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFee;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFeeResponse;
import com.vnsw.ws.p11.message.receive.PhytosanitaryProcess;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseCancel;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEdit;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEditCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResult;

public interface BackendService11 {
    ResponseJson getDataFromRestUri(String restUri);
    ResponseJson updateHoSoStatus(String fiMaHoso, Long fiTrangthai, String fiLydo);
    ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo);
    ResponseJson updateLichSuSend(String fiMaHoso, Long fiTrangthai);
    ResponseJson updateKqtd(PhytosanitaryResult phytosanitaryResult);
    ResponseJson updateXacNhanDon(RegistrationConfirm confirm);
    ResponseJson updateKQXinSuaHS(PhytosanitaryResponseEdit phytosanitaryResponseEdit);
    ResponseJson updateKQXinRutHS(PhytosanitaryResponseCancel phytosanitaryResponseCancel);
    ResponseJson tbApPhi(PhytosanitaryFee phytosanitaryFee);
    ResponseJson tbApPhiBoSung(PhytosanitaryFeeResponse phytosanitaryFeeResponse);
    ResponseJson tbGiayCN(PhytosanitaryCer phytosanitaryCer);
    ResponseJson denghiguiGCN(PhytosanitaryCerInfoRequest phytosanitaryCerInfoRequest);
    ResponseJson updateKQXinSuaGCN(PhytosanitaryResponseEditCer phytosanitaryResponseEditCer);
    ResponseJson lohangcanXL(PhytosanitaryProcess phytosanitaryProcess);
}