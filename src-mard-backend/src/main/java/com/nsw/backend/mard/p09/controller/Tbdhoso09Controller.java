package com.nsw.backend.mard.p09.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p09.dto.Hoso09DTO;
import com.nsw.backend.mard.p09.dto.send.RequestEdit;
import com.nsw.backend.mard.p09.dto.send.ResponseQualityResult;
import com.nsw.backend.mard.p09.dto.send.SendMessage;
import com.nsw.backend.mard.p09.model.FilterForm;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import com.nsw.backend.mard.p09.model.Tbdycpk09;
import com.nsw.backend.mard.p09.model.Tbdycrut09;
import com.nsw.backend.mard.p09.repositories.TbdXacnhan09Repository;
import com.nsw.backend.mard.p09.service.Tbdhoso09Service;
import com.nsw.backend.mard.p09.service.WsService;
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
@RequestMapping("/mard/09/hoso")
public class Tbdhoso09Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(Tbdhoso09Controller.class);
    private static final String TAG = "Tbdhoso09Controller";

    private static final String RESPONSE_NO_CONTENT = "No content";

    private final RabbitMQService rabbitMQService;

    private final Tbdhoso09Service regProfileService;

    private final WsService wsService;

    private final TbdXacnhan09Repository regConfirmationRepository;

    @Autowired
    public Tbdhoso09Controller(RabbitMQService rabbitMQService, Tbdhoso09Service regProfileService, WsService wsService, TbdXacnhan09Repository regConfirmationRepository) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
        this.wsService = wsService;
        this.regConfirmationRepository = regConfirmationRepository;
    }

    //------------------- Create a Tbdhoso09 --------
    @PostMapping("/")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody Hoso09DTO profile) {
        try {
            if (profile == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            return createSuccessResponse(regProfileService.saveDraftRegProfile(profile), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //------------------- Update a Tbdhoso09 --------
    @PostMapping(value = "/update")
    public ResponseEntity<ResponseJson> updateHosoAfterProcess(@RequestBody Hoso09DTO hosoDTO) {
        try {
            if (hosoDTO == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            Tbdhoso09 result = regProfileService.updateAfterSendNSW(Tbdhoso09.parse(hosoDTO));
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiHSCode());
            requestEdit.setFiReason(result.getFiModifyReason());
            requestEdit.setRegProfile(result);
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
    public ResponseEntity<ResponseJson> saveBeforeUpdate(@RequestBody Hoso09DTO hosoDTO) {
        try {
            if (hosoDTO == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            Tbdhoso09 result = regProfileService.updateAfterSendNSW(Tbdhoso09.parse(hosoDTO));
            regProfileService.getSignPendingProfiles().put(result.getFiHSCode(), true);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/update-only")
    public ResponseEntity<ResponseJson> updateOnly(@RequestBody Hoso09DTO hosoDTO) {
        try {
            if (hosoDTO == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            Tbdhoso09 result = regProfileService.findByFiHSCode(hosoDTO.getFiHSCode());
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(result.getFiHSCode());
            requestEdit.setFiReason(result.getFiModifyReason());
            requestEdit.setRegProfile(result);

            regProfileService.getSignPendingProfiles().invalidate(hosoDTO.getFiHSCode());
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
    public ResponseEntity<ResponseJson> cancelHosoAfterProcess(@RequestBody Tbdycrut09 requestCancel) {
        try {
            if (requestCancel == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            RequestEdit requestEdit = new RequestEdit();
            requestEdit.setFiRequestDate(new Date());
            requestEdit.setFiNSWFileCode(requestCancel.getFiHSCode());
            requestEdit.setFiReason(requestCancel.getFiReason());
            requestEdit.setRegProfile(regProfileService.findByFiHSCode(requestCancel.getFiHSCode()));
            ResponseJson response = wsService.requestCancelProfile(requestEdit);
            if (response.isSuccess()) {
                Tbdycrut09 result = regProfileService.cancelHoso(requestCancel);
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
            Tbdhoso09 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
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

    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody Hoso09DTO profile) {
        try {
            if (profile == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            Tbdhoso09 result = regProfileService.saveDraftRegProfile(profile);
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


    @PostMapping(value = "/remark")
    public ResponseEntity<ResponseJson> remarkHoso(@RequestBody ResponseQualityResult requestDTO) {
        try {
            if (requestDTO == null) {
                return createErrorResponse(RESPONSE_NO_CONTENT, HttpStatus.NO_CONTENT);
            }
            ResponseJson response = wsService.remarkQualityCertificate(requestDTO);
            if (response.isSuccess()) {
                Tbdycpk09 remarkRequest = new Tbdycpk09();
                remarkRequest.setFiHSCode(requestDTO.getFiNSWFileCode());
                remarkRequest.setFiReason(requestDTO.getFiDeescription());
                remarkRequest.setFiCreatedBy(requestDTO.getFiResponseUser());
                regProfileService.remarkHoso(remarkRequest);
                return createSuccessResponse(remarkRequest, HttpStatus.OK);
            } else {
                return createErrorResponse("Gửi yêu cầu phúc khảo không thành công", HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/xnd")
    public ResponseEntity<ResponseJson> findXNDByConfirmNo(@RequestParam String id) {
        return createSuccessResponse(regConfirmationRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(id).orElse(null), HttpStatus.OK);
    }

    //---------FOR SEARCHING PURPOSES
    @GetMapping("/find")
    public ResponseEntity<ResponseJson> findById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String taxCode,
            @RequestParam(required = false) String nswFileCode) {
        Tbdhoso09 regProfile;
        if (StringUtils.isNotEmpty(nswFileCode)) {
            regProfile = regProfileService.findByFiHSCode(nswFileCode);
        } else if (StringUtils.isNotEmpty(id)) {
            regProfile = regProfileService.findById(Long.parseLong(id));
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
