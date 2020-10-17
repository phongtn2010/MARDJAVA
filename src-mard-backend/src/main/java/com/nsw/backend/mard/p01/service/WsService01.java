package com.nsw.backend.mard.p01.service;

import com.nsw.backend.mard.p01.client.ResponseWrapper;
import com.nsw.backend.mard.p01.dto.RequestCancelCer;
import com.nsw.backend.mard.p01.dto.RequestEditCer;
import com.nsw.backend.mard.p01.dto.RequestProEdit;
import com.nsw.backend.mard.p01.dto.SendMessage;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import com.nsw.backend.util.ResponseJson;

public interface WsService01 {

    /**
     * Gửi mới hồ sơ
     */
    ResponseJson sendProfile(Tbdhoso01 regProfile) throws NSWException;

    /**
     * Doanh nghiệp yêu cầu hủy giấy CNKD
     */
    ResponseJson processRequestCancelCer(RequestCancelCer requestCancelCer) throws NSWException;

    /**
     * Doanh nghiệp yêu cầu sửa giấy CNKD
     */
    ResponseJson processRequestEditCer(RequestEditCer requestEditCer) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu 13A cho động vật
     */
    ResponseJson processCertificateForAnimal(ResponseWrapper request) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu 13B cho sản phẩm động vật
     */
    ResponseJson processCertificateProductAnimal(ResponseWrapper request) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu Hong Kong sản phẩm thịt lợn
     */
    ResponseJson processCertificateHongKongPig(ResponseWrapper request) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu Malaysia
     */
    ResponseJson processCertificateMalaysia(ResponseWrapper request) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu Hong Kong sản phẩm thịt gà
     */
    ResponseJson processCertificateHongKongChicken(ResponseWrapper request) throws NSWException;

    /**
     * chứng nhận kiểm dịch mẫu Trung Quốc
     */
    ResponseJson processCertificateChina(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông báo áp phí
     */
    ResponseJson processPhytosanitaryFee(ResponseWrapper request) throws NSWException;

    /**
     * Xử lý thông báo xác nhận phí
     */
    ResponseJson processFeeRequest(ResponseWrapper request) throws NSWException;

    /**
     * Kết quả thẩm định từ chối or sửa đổi bổ xung
     */
    ResponseJson processResult(ResponseWrapper request) throws NSWException;

    /**
     * Kết quả xin sửa hồ sơ
     */
    ResponseJson processCertificateResponseEdit(ResponseWrapper request) throws NSWException;

    /**
     * Kết quả xin hủy hồ sơ
     */
    ResponseJson processResponseCancel(ResponseWrapper request) throws NSWException;

    /**
     * Rút / yêu cầu rút hồ sơ
     */
    ResponseJson requestCancelProfile(RequestProEdit requestProEdit) throws NSWException;

    /**
     * Công văn kết quả không đạt yêu cầu xuất khẩu
     */
    ResponseJson processNotificationFailed(ResponseWrapper request) throws NSWException;

    /**
     * Kết quả hủy giấy CNKD
     */
    ResponseJson processResponseCancelCer(ResponseWrapper request) throws NSWException;

    /**
     * Từ chôi sửa giấy chứng nhật kiểm dịch
     */
    ResponseJson processResponseEditCer(ResponseWrapper request) throws NSWException;

    //=====================
    //Các hàm hỗ trợ khác
    //=====================

    ResponseJson updateProfile(RequestProEdit requestProEdit);

    ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException;

    ResponseJson getXml(SendMessage sendMessage) throws NSWException;
}
