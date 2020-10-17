package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p01.constant.Constant01;
import com.nsw.backend.mard.p01.dto.*;
import com.nsw.backend.mard.p01.model.FilterForm;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import com.nsw.backend.mard.p01.model.Tbdlichsu01;
import com.nsw.backend.mard.p01.model.Tbdycrut01;
import com.nsw.backend.mard.p01.service.Tbdhoso01Service;
import com.nsw.backend.mard.p01.service.Tbdlichsu01Service;
import com.nsw.backend.mard.p01.service.WsService01;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/mard/01/hoso")
public class Tbdhoso01Controller extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(Tbdhoso01Controller.class);
    private static final String TAG = "Tbdhoso01Controller";
    private final RabbitMQService rabbitMQService;
    private final Tbdhoso01Service regProfileService;
    private final Tbdlichsu01Service tbdlichsu01Service;
    private final WsService01 wsService;

    @Autowired
    public Tbdhoso01Controller(RabbitMQService rabbitMQService, Tbdhoso01Service tbdhoso01Service, Tbdlichsu01Service tbdlichsu01Service, WsService01 wsService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = tbdhoso01Service;
        this.tbdlichsu01Service = tbdlichsu01Service;
        this.wsService = wsService;
    }

    // tạo mới hồ sơ
    @PostMapping("/")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody Tbdhoso01 profile) {
        try {
            if (profile == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso01 result = saveDraftTbdhoso01(profile);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    // 10-01 vs 10-02 vs 10-03
    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody Tbdhoso01 profile) {
        try {
            if (profile == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            if (profile.getFiSignDate() == null) profile.setFiSignDate(new Date());
            Tbdhoso01 result = saveDraftTbdhoso01(profile);
            ResponseJson response = wsService.sendProfile(result);
            return createResponse(null, response.isSuccess(),
                    response.isSuccess() ?
                            "Hồ sơ đã gửi thành công!" :
                            "Có lỗi trong quá trình gửi! " + response.getMessage(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/getXml")
    public ResponseEntity<ResponseJson> getXml(@RequestBody SendMessage sendMessage) {
        try {
            if (sendMessage == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            ResponseJson result = wsService.getXml(sendMessage);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    // 11-04
    @PostMapping(value = "/proCancel")
    public ResponseEntity<ResponseJson> requestProCancel(@RequestBody RequestProCancel requestCancel) {
        try {
            if (requestCancel == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdycrut01 ruts01 = new Tbdycrut01();
            ruts01.setFiNSWFileCode(requestCancel.getFiNSWFileCode());
            ruts01.setFiRequestDate(requestCancel.getFiRequestDate());
            ruts01.setFiReason(requestCancel.getFiReason());
            RequestProEdit requestProEdit = new RequestProEdit();
            requestProEdit.setFiRequestDate(new Date());
            requestProEdit.setFiRegistrationProfile(regProfileService.findByFiHSCode(requestCancel.getFiNSWFileCode()));
            requestProEdit.setFiReason(requestCancel.getFiReason());

            ResponseJson response = wsService.requestCancelProfile(requestProEdit);
            if (response.isSuccess()) {
                Tbdycrut01 result = regProfileService.cancelHoso(ruts01);
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                return ResponseEntity.ok(response);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    // 14-08
    @PostMapping(value = "/update")
    public ResponseEntity<ResponseJson> updateHosoAfterProcess(@RequestBody RequestProEdit requestEdit) {
        try {
            if (requestEdit.getFiRegistrationProfile() == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            if (requestEdit.getFiRegistrationProfile().getFiSignDate() == null)
                requestEdit.getFiRegistrationProfile().setFiSignDate(new Date());
            Tbdhoso01 result = regProfileService.updateAfterSendNSW(requestEdit);
            ResponseJson response = wsService.updateProfile(requestEdit);
            if (response.isSuccess()) {
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                regProfileService.rollbackFailedRequestUpdate(result);
                return createErrorResponse("Có lỗi khi yêu cầu sửa! " + response.getMessage(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/save-before-update")
    public ResponseEntity<ResponseJson> saveBeforeUpdate(@RequestBody RequestProEdit requestProEdit) {
        try {
            if (requestProEdit.getFiRegistrationProfile() == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            if (requestProEdit.getFiRegistrationProfile().getFiSignDate() == null)
                requestProEdit.getFiRegistrationProfile().setFiSignDate(new Date());
            Tbdhoso01 result = regProfileService.updateAfterSendNSW(requestProEdit);
            regProfileService.getSignPendingProfiles().put(result.getFiNSWFileCode(), true);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update-only")
    public ResponseEntity<ResponseJson> updateOnly(@RequestBody RequestProEdit requestProEdit) {
        try {
            if (requestProEdit.getFiRegistrationProfile() == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso01 result = regProfileService.findByFiHSCode(requestProEdit.getFiRegistrationProfile().getFiNSWFileCode());
            if (requestProEdit.getFiRegistrationProfile().getFiSignDate() == null) {
                requestProEdit.getFiRegistrationProfile().setFiSignDate(new Date());
            }
            regProfileService.getSignPendingProfiles().invalidate(result.getFiNSWFileCode());
            ResponseJson response = wsService.updateProfile(requestProEdit);
            if (response.isSuccess()) {
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                regProfileService.rollbackFailedRequestUpdate(result);
                return createErrorResponse("Có lỗi khi gửi yêu cầu sửa! " + response.getMessage(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }


    // hủy hồ sơ sau tiếp nhận 16-11
    @PostMapping("/cancel")
    public ResponseEntity<ResponseJson> cancelHosoAfterProcess(@RequestBody RequestCancel requestCancel) {
        try {
            if (requestCancel == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdycrut01 ruts01 = new Tbdycrut01();
            ruts01.setFiNSWFileCode(requestCancel.getFiNSWFileCode());
            ruts01.setFiRequestDate(requestCancel.getFiRequestDate());
            ruts01.setFiReason(requestCancel.getFiReason());
            RequestProEdit requestProEdit = new RequestProEdit();
            requestProEdit.setFiRequestDate(new Date());
            requestProEdit.setFiRegistrationProfile(regProfileService.findByFiHSCode(requestCancel.getFiNSWFileCode()));
            requestProEdit.setFiReason(requestCancel.getFiReason());

            ResponseJson response = wsService.requestCancelProfile(requestProEdit);
            if (response.isSuccess()) {
                Tbdycrut01 result = regProfileService.cancelHoso(ruts01);
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                return ResponseEntity.ok(response);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    // 27-34
    @PostMapping("/cancelCer")
    public ResponseEntity<ResponseJson> requestCancelCNKD(@RequestBody RequestCancelCer requestCancelCer) {
        try {
            if (requestCancelCer == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            wsService.processRequestCancelCer(requestCancelCer);
            return createSuccessResponse("", HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    // 29-43
    @PostMapping("/editCer")
    public ResponseEntity<ResponseJson> requestEditCerCNKD(@RequestBody RequestEditCer requestEditCer) {
        try {
            if (requestEditCer == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            wsService.processRequestEditCer(requestEditCer);
            return createSuccessResponse("", HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseJson> findById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String taxCode,
            @RequestParam(required = false) String nswFileCode)
    {
        Tbdhoso01 regProfile;
        if(StringUtils.isNotEmpty(nswFileCode)){
            regProfile = regProfileService.findByFiHSCode(nswFileCode);
        }
        else if(StringUtils.isNotEmpty(id)){
            regProfile = regProfileService.findById(Long.parseLong(id));
        }
        else{
            regProfile = null;
        }
        if(regProfile != null
                && StringUtils.isNotEmpty(taxCode)
                && taxCode.equals(regProfile.getFiTaxCode()) == false){
            regProfile = null;
        }
        return createSuccessResponse(regProfile, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<ResponseJson> findByFilterForm(@RequestBody FilterForm filterForm) {
        regProfileService.getSignPendingProfiles().cleanUp();
        return createSuccessResponse(regProfileService.searchHoso(filterForm), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam String fiNSWFileCode,
            @RequestParam String fiTaxCode) {
        try {
            Tbdhoso01 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
            if (regProfile == null || !regProfile.getFiTaxCode().equals(fiTaxCode)) {
                throw new IllegalArgumentException("Hồ sơ không thuộc đơn vị đăng ký");
            } else {
                regProfile.setFiActive(false);
                regProfileService.save(regProfile);
                return createResponse("", true, "", HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/attachment-type")
    public ResponseEntity<ResponseJson> getAttachmentType() {
        return createSuccessResponse(Constant01.Hoso01AttachmentType.values(), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<ResponseJson> getHoso01Status() {
        return createSuccessResponse(Constant01.Hoso01Status.values(), HttpStatus.OK);
    }

    @GetMapping("/ma-bo-nganh")
    public ResponseEntity<ResponseJson> getHoso01MaBoNganh() {
        return createSuccessResponse(Constant01.Hoso01MaBoNganh.values(), HttpStatus.OK);
    }

    @GetMapping("/hang-hoa")
    public ResponseEntity<ResponseJson> getHoso01HangHoa() {
        return createSuccessResponse(Constant01.Hoso01HangHoa.values(), HttpStatus.OK);
    }

    @GetMapping("means-transport-name")
    public ResponseEntity<ResponseJson> getMeansTranSportName(@RequestParam String id) {
        if (id == null || id.equals("")) {
            return createSuccessResponse(Constant01.Hoso01PHuongTienVanChuyen.values(), HttpStatus.OK);
        } else {
            return createSuccessResponse(Constant01.Hoso01PHuongTienVanChuyen.findById(Integer.parseInt(id)), HttpStatus.OK);
        }
    }

    private Tbdhoso01 saveDraftTbdhoso01(Tbdhoso01 profile) {
        String historyContent;
        profile.setFiActive(true);
        if (profile.getFiIdHS() == null || profile.getFiIdHS() == 0) {
            profile = regProfileService.create(profile);
            historyContent = "Tạo mới hồ sơ";
        } else {
            Tbdhoso01 hoso = regProfileService.findById(profile.getFiIdHS());
            profile.setFiCreaterName(hoso.getFiCreaterName());
            profile.setFiCreatedBy(hoso.getFiCreatedBy());
            profile.setFiCreatedDate(hoso.getFiCreatedDate());
            profile.setFiPaymentStatus(hoso.getFiPaymentStatus());
            profile.setFiNSWFileCode(hoso.getFiNSWFileCode());
            profile.setFiLicenseNo(hoso.getFiLicenseNo());
            profile.setFiHSStatus(hoso.getFiHSStatus());

            if (hoso.getFiHSStatus() != Constant01.Hoso01Status.DA_TIEP_NHAN.getId()) {
                profile.setFiRegistrationNo(hoso.getFiRegistrationNo());
                profile.setFiRegistrationDate(hoso.getFiRegistrationDate());
                profile.setFiCheckPlace(hoso.getFiCheckPlace());
                profile.setFiCheckTime(hoso.getFiCheckTime());
                profile.setFiCreaterName(hoso.getFiCreaterName());
            }

            profile = regProfileService.update(profile);
            historyContent = "Cập nhật thông tin hồ sơ";
        }

        // Ghi lại lịch sử tạo mới
        Tbdlichsu01 profileHst = new Tbdlichsu01();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderUnitName(profile.getFiExporterNameVni());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        profileHst.setFiNSWFileCode(profile.getFiNSWFileCode());
        profileHst.setFiSenderCode(profile.getFiTaxCode());
        profileHst.setFiContent(historyContent);
        profileHst.setFiProcName("Proc 1");

        tbdlichsu01Service.create(profileHst);
        return profile;
    }

    @GetMapping(value = "/rollback")
    public ResponseEntity<ResponseJson> manualRollback(@RequestParam String nswFileCode) {
        try {
            regProfileService.rollbackFailedRequestUpdate(nswFileCode);
            return createSuccessResponse(null, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

}
