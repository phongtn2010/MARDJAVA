/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.dic.model.*;
import com.nsw.backend.dic.service.*;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p07.constant.Constant07;
import com.nsw.backend.mard.p08.constant.Constant08;
import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mard/danhmuc")
public class CommonController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
    private static final String TAG = "CommonController";

    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    CmonUnitService cmonUnitService;
    @Autowired
    CmonCountryService cmonCountryService;
    @Autowired
    CmonPortService cmonPortService;
    @Autowired
    CmonAttachtypeService cmonAttachtypeService;
    @Autowired
    CmonDvkdService cmonDvkdService;
    @Autowired
    CmonUnittypeService cmonUnittypeService;
    @Autowired
    CmonProvinceService cmonProvinceService;

    @Autowired
    CmonSeafoodprocessorsService cmonSeafoodprocessorsService;
    //------------------- Danh mục quốc gia ------------------------------------
    @GetMapping("/quocgia")
    public ResponseEntity<ResponseJson> getCountry() {
        try {
            return createSuccessResponse(cmonCountryService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //------------------- Danh mục cửa khẩu theo quốc gia ----------------------
    @GetMapping("/cuakhau")
    public ResponseEntity<ResponseJson> getPortByCountry(@RequestParam("countryCode") String countryCode) {
        try {
            return createSuccessResponse(cmonPortService.findByCountryCode(countryCode), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //------------------- Get list Unit Type---------------------------
    @GetMapping("/unittype")
    public ResponseEntity<ResponseJson> getUnitTypes() {
        try {
            return createSuccessResponse(cmonUnittypeService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //------------------- Get list unit of unitTypeId---------------------------
    @GetMapping("/unit")
    public ResponseEntity<ResponseJson> getUnitByUnitTypeId(
            @RequestParam("unitTypeId") Long unitTypeId,
            @RequestParam("systemId") Long systemId
    ) {
        try {
            return createSuccessResponse(cmonUnitService.findByUnitTypeIdAndSystemId(unitTypeId, systemId), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }


    //------------------- Get list Attachment of current System---------------------------
    @GetMapping("/dinhkem")
    public ResponseEntity<ResponseJson> getAttachType(@RequestParam("systemId") long systemId, @RequestParam(required = false) String type) {
        if (StringUtils.isEmpty(type)) {
            return createSuccessResponse(cmonAttachtypeService.findBySystemIdPhase2(systemId), HttpStatus.OK);
        } else {
            return createSuccessResponse(cmonAttachtypeService.findBySystemIdTemplateTypePhase2(systemId, type), HttpStatus.OK);
        }
    }

    @GetMapping("/tinhthanh")
    public ResponseEntity<ResponseJson> getProvince() {
        try {
            List<CmonProvince> countrys = cmonProvinceService.findAll();
            return createSuccessResponse(countrys, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/mdsd")
    public ResponseEntity<ResponseJson> getCatPurposes(@RequestParam("systemId") int systemId) {
        try {
            switch (systemId) {
                case 6:
                    return createSuccessResponse(Constant06.PurposeType.values(), HttpStatus.OK);
                default:
                    return createErrorResponse(" không hợp lệ", HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }


    //-------------------- Get list Registration Status by System------------------------
    @GetMapping("/statusHoso")
    public ResponseEntity<ResponseJson> getRegistrationStatuses(@RequestParam("systemId") int systemId) {
        switch (systemId) {
            case 6:
                return createSuccessResponse(Constant06.HosoStatus.values(), HttpStatus.OK);
            case 7:
                return createSuccessResponse(Constant07.HosoStatus.values(), HttpStatus.OK);
            case 8:
                return createSuccessResponse(Constant08.Hoso08Status.values(), HttpStatus.OK);
            case 9:
                return createSuccessResponse(Constant09.Hoso09Status.values(), HttpStatus.OK);
            default:
                return createErrorResponse("Mã thủ tục không hợp lệ", HttpStatus.OK);
        }
    }

    @PostMapping("/cssx")
    public ResponseEntity<ResponseJson> searchCSXX(@RequestBody FilterFormCmonSF filterFormCmonSF) {
        try {
            return createSuccessResponse(cmonSeafoodprocessorsService.searchCmonSeaFood(filterFormCmonSF),HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    @PostMapping("/cssx/update")
    public ResponseEntity<ResponseJson> updateCSXX(@RequestBody CmonSeafoodprocessors cmonSeafoodprocessors) {
        try {
            if (cmonSeafoodprocessors.getSeafoodprocessorsid()==null||cmonSeafoodprocessors.getSeafoodprocessorsid().equals(0L)){
                Long id=cmonSeafoodprocessorsService.maxId();
                cmonSeafoodprocessors.setSeafoodprocessorsid(id+1);
                return createSuccessResponse(cmonSeafoodprocessorsService.save(cmonSeafoodprocessors),HttpStatus.OK);
            }else{
                CmonSeafoodprocessors seafood = new CmonSeafoodprocessors();
                CmonSeafoodprocessors seafoodprocessors = cmonSeafoodprocessorsService.findById(cmonSeafoodprocessors.getSeafoodprocessorsid());
                BeanUtils.copyProperties(cmonSeafoodprocessors,seafood);
                seafood.setSeafoodprocessorsid(seafoodprocessors.getSeafoodprocessorsid());
                return createSuccessResponse(cmonSeafoodprocessorsService.save(seafood),HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    @PostMapping("/cssx/delete")
    public ResponseEntity<ResponseJson> deleteCSXX(@RequestBody CmonSeafoodprocessors cmonSeafoodprocessors) {
        try {
            cmonSeafoodprocessorsService.delete(cmonSeafoodprocessors.getSeafoodprocessorsid());
            return createSuccessResponse(null,HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
}
