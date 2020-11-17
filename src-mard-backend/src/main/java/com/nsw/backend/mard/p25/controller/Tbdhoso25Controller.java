/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.model.*;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.mard.p25.service.TbdYcrut25Service;
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
    private static final String TAG = "Tbdhoso25Controller";

    private final RabbitMQService rabbitMQService;

    private final TbdHoso25Service tbdHoso25Service;

    private final TbdLichsu25Service tbdLichsu25Service;

    private final TbdYcrut25Service tbdYcrut25Service;

    private final WsService wsService;

    @Autowired
    public Tbdhoso25Controller(RabbitMQService rabbitMQService, TbdHoso25Service tbdHoso25Service, TbdLichsu25Service tbdLichsu25Service, WsService wsService, TbdYcrut25Service tbdYcrut25Service) {
        this.rabbitMQService = rabbitMQService;
        this.tbdHoso25Service = tbdHoso25Service;
        this.tbdLichsu25Service = tbdLichsu25Service;
        this.wsService = wsService;
        this.tbdYcrut25Service=tbdYcrut25Service;
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
            profileHst.setFiStatus(profile.getFiHSStatus());
            tbdHoso25Service.save(profile);
            tbdLichsu25Service.update(profileHst);
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
           return null;

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
            TbdHoso25 result = tbdHoso25Service.updateAfterSendNSW(hoso);
            tbdHoso25Service.getSignPendingProfiles().put(result.getFiNSWFileCode(), true);
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
            tbdHoso25Service.rollbackFailedRequestUpdate(nswFileCode);
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
           return null;
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

            TbdHoso25 regProfile = tbdHoso25Service.findByFiHSCode(requestCancel.getFiNSWFileCode());
            ResponseJson response = wsService.yeuCauRutHS(requestCancel);
            return  ResponseEntity.ok(response);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam Integer fiIdHS,
            @RequestParam String fiTaxCode) {
        try {
            TbdHoso25 regProfile = tbdHoso25Service.findById(fiIdHS);
            if (regProfile == null || !regProfile.getFiTaxCode().equals(fiTaxCode)) {
                throw new IllegalArgumentException("Hồ sơ không thuộc đơn vị đăng ký");
            } else {
                regProfile.setFiActive(false);
                tbdHoso25Service.save(regProfile);
                return createResponse("", true, "", HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    @PostMapping("/chuyenchitieu")
    public ResponseEntity<ResponseJson> chuyenChiTieu(@RequestBody TbdHoso25 tbdHoso25) {
        try {
            if (tbdHoso25 == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }

            if (null==tbdHoso25) {
                return createErrorResponse("Fail", HttpStatus.OK);
            }
            //luu thong tin don vi xu ly truoc khi chuyen
            tbdHoso25Service.update(tbdHoso25);
            ResponseJson response = wsService.chuyenChiTieu(tbdHoso25);
            return ResponseEntity.ok(response);
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
            regProfile = tbdHoso25Service.findByFiHSCode(nswFileCode);
        } else if (StringUtils.isNotEmpty(id)) {
            regProfile = tbdHoso25Service.findById(Integer.parseInt(id));
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
    @PostMapping("/nopkq")
    public ResponseEntity<ResponseJson> guiXuLyKQ(@RequestBody TbdKQXL25 tbdKQXL25) {
        try {
            if (null==tbdKQXL25) {
                return createErrorResponse("Fail", HttpStatus.OK);
            }
            TbdHoso25 tbdHoso25 = tbdHoso25Service.findByFiHSCode(tbdKQXL25.getFiNSWFileCode());
            ResponseJson response = wsService.dnNopKQ(tbdKQXL25,tbdHoso25);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/find-by-status")
    public ResponseEntity<ResponseJson> findByStatus(
            @RequestParam(name = "taxCode") String taxCode,
            @RequestParam(name = "from") Integer from,
            @RequestParam(name = "to") Integer to) {
        return createSuccessResponse(tbdHoso25Service.findByFiHSStatus(taxCode,from, to), HttpStatus.OK);
    }
    @PostMapping("/find")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterForm filterForm) {
//        tbdHoso25Service.getSignPendingProfiles().cleanUp();
        return createSuccessResponse(tbdHoso25Service.searchHoso(filterForm), HttpStatus.OK);
    }

    //-----------MISC
    private TbdHoso25 saveDraftTbdhoso25(@RequestBody TbdHoso25 profile) {
        String historyContent;
        if (profile.getFiIdHS() == null || profile.getFiHSStatus() == null) {
            profile.setFiHSStatus(Constant25.HosoStatus.TAO_MOI.getId());
            profile.setFiHSCreatedDate(new Date());
            profile = tbdHoso25Service.create(profile);
            historyContent = "Tạo mới hồ sơ";
        } else {
            profile = tbdHoso25Service.update(profile);
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
        tbdLichsu25Service.create(profileHst);
        return profile;
    }
}
