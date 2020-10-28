package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.client.ResponseWrapper;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.mard.p25.model.TbdHoso25;
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

    ResponseJson tiepNhanHS2D(ResponseWrapper request);

    ResponseJson thuHoiGDK(ResponseWrapper request);

    ResponseJson tccdGuiKQKT(ResponseWrapper request);

    ResponseJson guiXuLyKQ(ResponseWrapper request);

    ResponseJson guiGiayXNCL(ResponseWrapper request);

    ResponseJson thuHoiGiayXNCL(ResponseWrapper request);
}
