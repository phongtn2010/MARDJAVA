package com.nsw.backend.mard.p07.service;

import com.nsw.backend.mard.p07.client.Header;
import com.nsw.backend.mard.p07.client.ResponseWrapper;
import com.nsw.backend.mard.p07.client.SendMessage;
import com.nsw.backend.mard.p07.dto.RequestEdit;
import com.nsw.backend.mard.p07.dto.RequestEditCer;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.util.ResponseJson;

public interface WsService {
    /**
     * Gửi mới hồ sơ
     *
     * @param regProfile
     * @return
     */
    ResponseJson sendProfile(TbdHoso07 regProfile) throws NSWException;

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
     * Yêu cầu hỉnh sửa giấy CN
     */
    ResponseJson requestModifyCertificate(RequestEditCer something) throws NSWException;

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
    ResponseJson processCertificateModificationRequest(ResponseWrapper request);

    /**
     * Xử lý thông báo CNKD Khong Dat
     */
    ResponseJson processQuarantineFailedNotification(ResponseWrapper request) throws NSWException;

    //=====================
    //Các hàm hỗ trợ khác
    //=====================
    ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException;

    void internalStatusUpdate(Header header, String exactSenderName, int status, String... reasons) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;

    void migrateData();
}
