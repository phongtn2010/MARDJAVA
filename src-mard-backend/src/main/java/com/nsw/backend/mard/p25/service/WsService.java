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

    ResponseJson tiepNhanKetQuaXN(ResponseWrapper request) throws NSWException;

    ResponseJson tiepNhanKetQuaXuLy(ResponseWrapper request) throws NSWException;


    //=====================
    //Các hàm hỗ trợ khác
    //=====================
    ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;
}
