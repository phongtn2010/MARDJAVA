/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p07.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p07.client.SendMessage;
import com.nsw.backend.mard.p07.dto.RequestEdit;
import com.nsw.backend.mard.p07.model.FilterForm;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.model.TbdXacnhan07;
import com.nsw.backend.mard.p07.model.TbdYcrut07;
import com.nsw.backend.mard.p07.service.TbdHoso07Service;
import com.nsw.backend.mard.p07.service.WsService;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/mard/07/hoso")
public class Tbdhoso07Controller extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(Tbdhoso07Controller.class);
    private static final String TAG = "Tbdhoso07Controller";

    private final RabbitMQService rabbitMQService;

    private final TbdHoso07Service regProfileService;

    private final WsService wsService;

    @Autowired
    public Tbdhoso07Controller(RabbitMQService rabbitMQService, TbdHoso07Service regProfileService, WsService wsService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
        this.wsService = wsService;
    }

    //------------------- Create a Tbdhoso07 --------
    // ---------------------------
    @PostMapping("/")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody TbdHoso07 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            return createSuccessResponse(regProfileService.saveDraftTbdHoso(profile), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody TbdHoso07 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso07 result = regProfileService.saveDraftTbdHoso(profile);
            ResponseJson response = wsService.sendProfile(result);
            return createResponse(null, response.isSuccess(),
                    response.isSuccess() ?
                            "Hồ sơ đã gửi thành công!" :
                            "Có lỗi trong quá trình gửi! " + response.getMessage(), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ResponseJson> updateHosoAfterProcess(@RequestBody TbdHoso07 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso07 result = regProfileService.updateAfterSendNSW(hoso);
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiNSWFileCode());
            requestEdit.setFiReason(hoso.getFiModifyReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(result.getFiNSWFileCode()));

            ResponseJson response = wsService.updateProfile(requestEdit);
            if (response.isSuccess()) {
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                regProfileService.rollbackFailedRequestUpdate(result);
                return createErrorResponse("Có lỗi khi yêu cầu sửa! " + response.getMessage(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/save-before-update")
    public ResponseEntity<ResponseJson> saveBeforeUpdate(@RequestBody TbdHoso07 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso07 result = regProfileService.updateAfterSendNSW(hoso);
            regProfileService.getSignPendingProfiles().put(result.getFiNSWFileCode(), true);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update-only")
    public ResponseEntity<ResponseJson> updateOnly(@RequestBody TbdHoso07 hoso) {
        try {
            if (hoso == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHoso07 result = regProfileService.findByFiHSCode(hoso.getFiNSWFileCode());
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiNSWFileCode());
            requestEdit.setFiReason(result.getFiModifyReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(result.getFiNSWFileCode()));

            regProfileService.getSignPendingProfiles().invalidate(hoso.getFiNSWFileCode());
            ResponseJson response = wsService.updateProfile(requestEdit);
            if (response.isSuccess()) {
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                regProfileService.rollbackFailedRequestUpdate(result);
                return createErrorResponse("Có lỗi khi yêu cầu sửa! " + response.getMessage(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
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
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/cancel")
    public ResponseEntity<ResponseJson> cancelHosoAfterProcess(@RequestBody TbdYcrut07 cancelRequest) {
        try {
            if (cancelRequest == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(cancelRequest.getFiNSWFileCode());
            requestEdit.setFiReason(cancelRequest.getFiReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(cancelRequest.getFiNSWFileCode()));
            ResponseJson response = wsService.requestCancelProfile(requestEdit);
            if (response.isSuccess()) {
                TbdYcrut07 result = regProfileService.cancelHoso(cancelRequest);
                return createSuccessResponse(result, HttpStatus.OK);
            } else {
                return createErrorResponse("Có lỗi trong khi gửi yêu cầu: " + response.getMessage(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam String fiNSWFileCode,
            @RequestParam String fiTaxCode) {
        try {
            TbdHoso07 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
            if (regProfile == null || !regProfile.getFiTaxCode().equals(fiTaxCode)) {
                throw new IllegalArgumentException("Hồ sơ không thuộc đơn vị đăng ký");
            } else {
                regProfile.setFiActive(false);
                regProfileService.save(regProfile);
                return createResponse("", true, "", HttpStatus.OK);
            }
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
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
        TbdHoso07 regProfile;
        if(StringUtils.isNotEmpty(nswFileCode)){
            regProfile = regProfileService.findByFiHSCode(nswFileCode);
        }
        else if(StringUtils.isNotEmpty(id)){
            regProfile = regProfileService.findById(Integer.parseInt(id));
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

    @GetMapping(value = "/rollback")
    public ResponseEntity<ResponseJson> manualRollback(@RequestParam String nswFileCode) {
        try {
            regProfileService.rollbackFailedRequestUpdate(nswFileCode);
            return createSuccessResponse(null, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
}
