/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p08.client.RequestEdit;
import com.nsw.backend.mard.p08.client.SendMessage;
import com.nsw.backend.mard.p08.constant.Constant08;
import com.nsw.backend.mard.p08.model.FilterForm;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import com.nsw.backend.mard.p08.model.Tbdlichsu08;
import com.nsw.backend.mard.p08.model.Tbdycrut08;
import com.nsw.backend.mard.p08.service.Tbdhoso08Service;
import com.nsw.backend.mard.p08.service.Tbdlichsu08Service;
import com.nsw.backend.mard.p08.service.WsService08;
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
@RequestMapping("/mard/08/hoso")
public class Tbdhoso08Controller extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(Tbdhoso08Controller.class);
    private static final String TAG = "Tbdhoso08Controller";

    private final RabbitMQService rabbitMQService;

    private final Tbdhoso08Service regProfileService;

    private final Tbdlichsu08Service tbdlichsu08Service;

    private final WsService08 wsService;

    @Autowired
    public Tbdhoso08Controller(RabbitMQService rabbitMQService, Tbdhoso08Service regProfileService, Tbdlichsu08Service tbdlichsu08Service, WsService08 wsService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
        this.tbdlichsu08Service = tbdlichsu08Service;
        this.wsService = wsService;
    }

    //------------------- Create a Tbdhoso08 --------
    // ---------------------------
    @PostMapping("/")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody Tbdhoso08 profile) {
        try {
            if (profile == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso08 result = saveDraftTbdhoso08(profile);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody Tbdhoso08 profile) {
        try {
            if (profile == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso08 result = saveDraftTbdhoso08(profile);
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

    @PostMapping(value = "/update")
    public ResponseEntity<ResponseJson> updateHosoAfterProcess(@RequestBody Tbdhoso08 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso08 result = regProfileService.updateAfterSendNSW(hoso);

            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiHSCode());
            requestEdit.setFiReason(hoso.getFiModifyReason());
            requestEdit.setRegProfile(result);
            ResponseJson response = wsService.requestUpdateProfile(requestEdit);
            if (response.isSuccess()) {
                // Ghi lại lịch sử cập nhật
                Tbdlichsu08 profileHst = new Tbdlichsu08();
                profileHst.setFiIdHS(result.getFiIdHS());
                profileHst.setFiHSCode(result.getFiHSCode());
                profileHst.setFiStatus(result.getFiHSStatus());
                profileHst.setFiSenderUnitName(result.getFiImporterName());
                profileHst.setFiSenderName(result.getFiTaxCode());
                profileHst.setFiContent("Cập nhật hồ sơ tạo yêu cầu xin sửa");
                tbdlichsu08Service.save(profileHst);
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
    public ResponseEntity<ResponseJson> saveBeforeUpdate(@RequestBody Tbdhoso08 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso08 result = regProfileService.updateAfterSendNSW(hoso);
            regProfileService.getSignPendingProfiles().put(result.getFiHSCode(), true);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update-only")
    public ResponseEntity<ResponseJson> updateOnly(@RequestBody Tbdhoso08 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            Tbdhoso08 result = regProfileService.findByFiHSCode(hoso.getFiHSCode());
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiHSCode());
            requestEdit.setFiReason(hoso.getFiModifyReason());
            requestEdit.setRegProfile(result);

            regProfileService.getSignPendingProfiles().invalidate(hoso.getFiHSCode());
            ResponseJson response = wsService.requestUpdateProfile(requestEdit);
            if(response.isSuccess()) {
                // Ghi lại lịch sử cập nhật
                Tbdlichsu08 profileHst = new Tbdlichsu08();
                profileHst.setFiIdHS(result.getFiIdHS());
                profileHst.setFiHSCode(result.getFiHSCode());
                profileHst.setFiStatus(result.getFiHSStatus());
                profileHst.setFiSenderUnitName(result.getFiImporterName());
                profileHst.setFiSenderName(result.getFiTaxCode());
                profileHst.setFiContent("Cập nhật hồ sơ tạo yêu cầu xin sửa");
                tbdlichsu08Service.save(profileHst);
                return createSuccessResponse(result, HttpStatus.OK);
            }
            else{
                regProfileService.rollbackFailedRequestUpdate(result);
                return createErrorResponse("Có lỗi khi gửi yêu cầu sửa! " + response.getMessage(), HttpStatus.OK);
            }
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

    @PostMapping("/cancel")
    public ResponseEntity<ResponseJson> cancelHosoAfterProcess(@RequestBody Tbdycrut08 ruts08) {
        try {
            if (ruts08 == null) {
                return createErrorResponse(null, HttpStatus.NO_CONTENT);
            }
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(ruts08.getFiHSCode());
            requestEdit.setFiReason(ruts08.getFiReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(ruts08.getFiHSCode()));
            ResponseJson response = wsService.requestCancelProfile(requestEdit);
            if(response.isSuccess()) {
                Tbdycrut08 result = regProfileService.cancelHoso(ruts08);
                return createSuccessResponse(result, HttpStatus.OK);
            }
            else{
                return ResponseEntity.ok(response);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam String fiNSWFileCode,
            @RequestParam String fiTaxCode) {
        try {
            Tbdhoso08 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
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

    //---------FOR SEARCHING PURPOSES
    @GetMapping("/find")
    public ResponseEntity<ResponseJson> findById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String taxCode,
            @RequestParam(required = false) String nswFileCode)
    {
        Tbdhoso08 regProfile;
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
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterForm filterForm) {
        regProfileService.getSignPendingProfiles().cleanUp();
        return createSuccessResponse(regProfileService.searchHoso(filterForm), HttpStatus.OK);
    }

    //-----------PRIVATE CATEGORIES
    @GetMapping("/type")
    public ResponseEntity<ResponseJson> getHSType() {
        return createSuccessResponse(Constant08.Hoso08Type.values(), HttpStatus.OK);
    }

    @GetMapping("/doctype")
    public ResponseEntity<ResponseJson> getDoctype() {
        return createSuccessResponse(Constant08.Hoso08AttachedDocType.values(), HttpStatus.OK);
    }

    //-----------MISC
    private Tbdhoso08 saveDraftTbdhoso08(@RequestBody Tbdhoso08 profile) {
        String historyContent;
        if (profile.getFiHSStatus() == null || profile.getFiIdHS() == null) {
            profile.setFiHSStatus((long) Constant08.Hoso08Status.TAO_MOI.getId());
            profile.setFiHSCreatedDate(new Date());
            profile = regProfileService.create(profile);
            historyContent = "Tạo mới hồ sơ";
        } else {
            profile.setFiHSStatus(null);
            profile = regProfileService.update(profile);
            historyContent = "Cập nhật hồ sơ";
        }
        // Ghi lại lịch sử tạo mới
        Tbdlichsu08 profileHst = new Tbdlichsu08();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiHSCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiSenderUnitName(profile.getFiImporterName());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        profileHst.setFiContent(historyContent);
        tbdlichsu08Service.create(profileHst);
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
