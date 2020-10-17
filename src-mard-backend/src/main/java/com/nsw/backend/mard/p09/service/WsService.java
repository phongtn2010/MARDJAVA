package com.nsw.backend.mard.p09.service;

import com.nsw.backend.mard.p09.client.Header;
import com.nsw.backend.mard.p09.client.ResponseWrapper;
import com.nsw.backend.mard.p09.dto.send.RequestEdit;
import com.nsw.backend.mard.p09.dto.send.RequestEditCer;
import com.nsw.backend.mard.p09.dto.send.ResponseQualityResult;
import com.nsw.backend.mard.p09.dto.send.SendMessage;
import com.nsw.backend.mard.p09.exception.NSWException;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import com.nsw.backend.util.ResponseJson;

public interface WsService {
    /**
     * Gửi mới hồ sơ
     *
     * @param regProfile
     * @return
     */
    ResponseJson sendProfile(Tbdhoso09 regProfile) throws NSWException;

    /**
     * Cập nhật / Yêu cầu cập nhật hồ sơ
     *
     * @param requestEdit
     * @return
     */
    ResponseJson updateProfile(RequestEdit requestEdit);

    /**
     * Rút / yêu cầu rút hồ sơ
     *
     * @param
     * @return
     */
    ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException;

    /**
     * Phản hồi kết quả XNCL
     *
     * @param qualityResult
     * @return
     */
    ResponseJson remarkQualityCertificate(ResponseQualityResult qualityResult);

    /**
     * Yêu cầu hỉnh sửa giấy CN
     */
    ResponseJson requestModifyCertificate(RequestEditCer something);

    /**
     * Xử lý kết quả thẩm định
     *
     * @return
     */
    ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông tin xác nhận đơn
     *
     * @param request
     * @return
     */
    ResponseJson processProfileConfirmation(ResponseWrapper request) throws NSWException;

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
     * Xử lý thông tin giấy CNKD
     */
    ResponseJson processAnimalQuarantineResult(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông tin GVC
     */
    ResponseJson processTransportResult(ResponseWrapper request) throws NSWException;


    /**
     * Xử lý thông tin thông báo XNCL
     */
    ResponseJson processQualityResultNotification(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông tin giấy XNCL
     */
    ResponseJson processQualityResult(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông báo áp phí
     */
    ResponseJson processFeeNotification(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông báo phí bổ sung
     */
    ResponseJson processAdditionalFeeNotification(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý xác nhận thanh toán phí
     */
    ResponseJson processFeeConfirmation(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý kết quả yêu cầu xin sửa GCN
     */
    ResponseJson processCertificateModificationRequest(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông báo không cấp GCNKD
     */
    ResponseJson processQuarantineFailedNotification(ResponseWrapper request) throws NSWException;

    //=====================
    //Các hàm hỗ trợ khác
    //=====================
    ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;
}
