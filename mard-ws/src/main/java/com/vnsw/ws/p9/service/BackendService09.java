/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p9.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p9.envelop.Header;
import com.vnsw.ws.p9.message.ResponseWrapper;


public interface BackendService09 {

    ResponseJson getDataFromRestUri(String restUri);

    ResponseJson updateHoSoStatus(Header header, String fiMaHoso, Long fiTrangthai, String fiLydo);

    ResponseJson updateKqtd(ResponseWrapper value);

    ResponseJson updateXacNhanDonDangKy(ResponseWrapper value);

    ResponseJson updateKetQuaXinSuaHS(ResponseWrapper value);

    ResponseJson updateKetQuaXinRutHS(ResponseWrapper value);

    ResponseJson updateGiayCNKD(ResponseWrapper value);

    ResponseJson updateGiayVanChuyen(ResponseWrapper value);

    ResponseJson updateGiayXNCL(ResponseWrapper value);

    ResponseJson thongBaoApPhi(ResponseWrapper value);

    ResponseJson thongbaoApphiBoxung(ResponseWrapper value);

    ResponseJson xacnhanPhi(ResponseWrapper value);

    ResponseJson nhanCongvanXNCLKhongdat(ResponseWrapper value);

    ResponseJson thongBaoKhongCapCNKD(ResponseWrapper value);

    ResponseJson phanHoiYeucauSuaGCN(ResponseWrapper value);

    ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo, Long loaiGCN, String maGCN);

}