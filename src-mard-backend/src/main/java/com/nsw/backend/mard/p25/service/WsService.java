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
    /**
     * Cập nhật / Yêu cầu cập nhật hồ sơ
     *
     * @param requestEdit
     * @return
     */
//    ResponseJson updateProfile(RequestEdit requestEdit);
    /**
     * Rút / yêu cầu rút hồ sơ
     *
     * @param
     * @return
     */
//    ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException;
    /**
     * Xử lý kết quả thẩm định
     *
     * @return
     */
    ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException;
    /**
     * Xử lý kết quả yêu cầu chỉnh sửa hồ sơ
     *
     * @return
     */
    ResponseJson processRequestUpdateProfileResponse(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý kết quả yêu cầu rút hồ sơ
     */

    ResponseJson processRequestCancelProfileResponse(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông tin giấy KDNK
     */
    ResponseJson processQuarantineResult(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông tin giấy VSTY
     */
    ResponseJson processVeterinaryHygieneResult(ResponseWrapper request) throws NSWException;


    /**
     * Xử lý thông báo VSTY không đạt
     */
    ResponseJson processVeterinaryHygieneFail(ResponseWrapper request) throws NSWException;

    //=====================
    //Các hàm hỗ trợ khác
    //=====================
    ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;
}
