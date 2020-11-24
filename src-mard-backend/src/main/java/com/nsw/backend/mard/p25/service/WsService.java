package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.client.ResponseWrapper;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.dto.UploadBaoCao;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.model.TbdKQXL25;
import com.nsw.backend.mard.p25.model.TbdYcrut25;
import com.nsw.backend.util.ResponseJson;

public interface WsService {
    /**
     * Gửi mới hồ sơ
     *
     * @param regProfile
     * @return
     */
    ResponseJson sendProfile(TbdHoso25 regProfile) throws NSWException;

    ResponseJson xacNhanDonDK(ResponseWrapper request) throws NSWException;

    ResponseJson tiepNhanKetQuaXuLy(ResponseWrapper request) throws NSWException;


    //=====================
    //Các hàm hỗ trợ khác
    //=====================

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;

    ResponseJson tiepNhanHS2D(ResponseWrapper request) throws NSWException;

    ResponseJson thuHoiGDK(ResponseWrapper request)  throws NSWException;

    ResponseJson tccdGuiKQKT(ResponseWrapper request)  throws NSWException;

    ResponseJson guiXuLyKQ(ResponseWrapper request)  throws NSWException;

    ResponseJson guiGiayXNCL(ResponseWrapper request)  throws NSWException;

    ResponseJson thuHoiGiayXNCL(ResponseWrapper request)  throws NSWException;

    ResponseJson chuyenChiTieu(TbdHoso25 tbdHoso25)  throws NSWException;

    ResponseJson yeuCauRutHS(TbdYcrut25 requestCancel);

    ResponseJson dnNopKQ(TbdKQXL25 tbdKQXL25, TbdHoso25 tbdHoso25)  throws NSWException;

    ResponseJson baoCaoHS2D(UploadBaoCao baoCao);
}
