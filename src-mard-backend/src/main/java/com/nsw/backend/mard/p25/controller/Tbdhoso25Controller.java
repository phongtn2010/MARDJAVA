/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.RequestEdit;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.model.TbdLichsu25;
import com.nsw.backend.mard.p25.model.TbdYcrut25;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.mard.p25.service.WsService;
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
@RequestMapping("/mard/25/hoso")
public class Tbdhoso25Controller extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(Tbdhoso25Controller.class);
    private static final String TAG = "Tbdhoso06Controller";

    private final RabbitMQService rabbitMQService;

    private final TbdHoso25Service regProfileService;

    private final TbdLichsu25Service hstService;

    private final WsService wsService;

    @Autowired
    public Tbdhoso25Controller(RabbitMQService rabbitMQService, TbdHoso25Service regProfileService, TbdLichsu25Service hstService, WsService wsService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.wsService = wsService;
    }

    //------------------- Create a Tbdhoso06 --------
    // ---------------------------
    @PostMapping("/create")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody TbdHoso25 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso25 result = saveDraftTbdhoso25(profile);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody TbdHoso25 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso25 result = saveDraftTbdhoso25(profile);
            TbdLichsu25 profileHst = new TbdLichsu25();
            profileHst.setFiIdHS(result.getFiIdHS());
            profileHst.setFiHSCode(result.getFiNSWFileCode());
            profileHst.setFiStatus(result.getFiHSStatus());
            profileHst.setFiSenderCode(result.getFiCreatedBy());
            profileHst.setFiSenderName(result.getFiTaxCode());
            //profileHst.setFiSenderUnitName(result.getFiImporterName());
            profileHst.setFiContent("Gửi mới hồ sơ");
            profile.setFiHSStatus(profile.getFiHSStatus());
            regProfileService.save(profile);
            hstService.update(profileHst);
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
    public ResponseEntity<ResponseJson> updateHosoAfterProcess(@RequestBody TbdHoso25 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso25 result = regProfileService.updateAfterSendNSW(hoso);
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiNSWFileCode());
            requestEdit.setFiReason(result.getFiReason());
            requestEdit.setRegProfile(result);
            ResponseJson response = wsService.updateProfile(requestEdit);
            if (response.isSuccess()) {
                TbdLichsu25 profileHst = new TbdLichsu25();
                profileHst.setFiIdHS(result.getFiIdHS());
                profileHst.setFiHSCode(result.getFiNSWFileCode());
                profileHst.setFiStatus(result.getFiHSStatus());
                profileHst.setFiSenderCode(result.getFiCreatedBy());
                //profileHst.setFiSenderUnitName(result.getFiImporterName());
                profileHst.setFiSenderName(result.getFiTaxCode());
                profileHst.setFiContent("Cập nhật hồ sơ tạo yêu cầu xin sửa");
                hstService.save(profileHst);
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
    public ResponseEntity<ResponseJson> saveBeforeUpdate(@RequestBody TbdHoso25 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso25 result = regProfileService.updateAfterSendNSW(hoso);
            regProfileService.getSignPendingProfiles().put(result.getFiNSWFileCode(), true);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
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

    @PostMapping(value = "/update-only")
    public ResponseEntity<ResponseJson> updateOnly(@RequestBody TbdHoso25 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso25 result = regProfileService.findByFiHSCode(hoso.getFiNSWFileCode());
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiNSWFileCode());
            requestEdit.setFiReason(result.getFiReason());
            requestEdit.setRegProfile(result);

            regProfileService.getSignPendingProfiles().invalidate(hoso.getFiNSWFileCode());
            ResponseJson response = wsService.updateProfile(requestEdit);
            if (response.isSuccess()) {
                TbdLichsu25 profileHst = new TbdLichsu25();
                profileHst.setFiIdHS(result.getFiIdHS());
                profileHst.setFiHSCode(result.getFiNSWFileCode());
                profileHst.setFiStatus(result.getFiHSStatus());
                profileHst.setFiSenderCode(result.getFiCreatedBy());
                //profileHst.setFiSenderUnitName(result.getFiImporterName());
                profileHst.setFiSenderName(result.getFiTaxCode());
                profileHst.setFiContent("Cập nhật hồ sơ tạo yêu cầu xin sửa");
                hstService.save(profileHst);
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

    @PostMapping(value = "/cancel")
    public ResponseEntity<ResponseJson> cancelHosoAfterProcess(@RequestBody TbdYcrut25 requestCancel) {
        try {
            if (requestCancel == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(requestCancel.getFiNSWFileCode());
            requestEdit.setFiReason(requestCancel.getFiReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(requestCancel.getFiNSWFileCode()));
            ResponseJson response = wsService.requestCancelProfile(requestEdit);
            if (response.isSuccess()) {
                TbdYcrut25 result = regProfileService.cancelHoso(requestCancel);
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

    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam String fiNSWFileCode,
            @RequestParam String fiTaxCode) {
        try {
            TbdHoso25 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
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
            @RequestParam(required = false) String nswFileCode) {
        TbdHoso25 regProfile;
        if (StringUtils.isNotEmpty(nswFileCode)) {
            regProfile = regProfileService.findByFiHSCode(nswFileCode);
        } else if (StringUtils.isNotEmpty(id)) {
            regProfile = regProfileService.findById(Integer.parseInt(id));
        } else {
            regProfile = null;
        }
        if (regProfile != null
                && StringUtils.isNotEmpty(taxCode)
                && taxCode.equals(regProfile.getFiTaxCode()) == false) {
            regProfile = null;
        }
        return createSuccessResponse(regProfile, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterForm filterForm) {
        regProfileService.getSignPendingProfiles().cleanUp();
        return createSuccessResponse(regProfileService.searchHoso(filterForm), HttpStatus.OK);
    }

    //-----------MISC
    private TbdHoso25 saveDraftTbdhoso25(@RequestBody TbdHoso25 profile) {
        String historyContent;
        if (profile.getFiIdHS() == null || profile.getFiHSStatus() == null) {
            profile.setFiHSStatus(Constant25.HosoStatus.TAO_MOI.getId());
            profile.setFiHSCreatedDate(new Date());
            profile = regProfileService.create(profile);
            historyContent = "Tạo mới hồ sơ";
        } else {
            profile.setFiHSStatus(null);
            profile = regProfileService.update(profile);
            historyContent = "Cập nhật hồ sơ";
        }
        TbdLichsu25 profileHst = new TbdLichsu25();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        //profileHst.setFiSenderUnitName(profile.getFiImporterName());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        profileHst.setFiContent(historyContent);
        hstService.create(profileHst);
        return profile;
    }
}
