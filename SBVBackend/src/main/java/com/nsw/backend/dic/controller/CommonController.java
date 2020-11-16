package com.nsw.backend.dic.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.dic.service.CmonDVTService;
import com.nsw.backend.dic.service.CmonPortService;
import com.nsw.backend.dic.service.CmonTienTeService;
import com.nsw.backend.dic.service.CmonVangService;
import com.nsw.backend.helper.RabbitMQErrorHelper;

import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sbv/02/danhmuc")
public class CommonController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
    private static final String TAG = "CommonController";

    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    CmonPortService cmonPortService;
    @Autowired
    CmonVangService cmonGoldService;
    @Autowired
    CmonDVTService cmonDVTService;
    @Autowired
    CmonTienTeService cmonTienTeService;

//    ------------------- Danh mục cửa khẩu  ----------------------
    @GetMapping("/cuakhau")
    public ResponseEntity<ResponseJson> getCuaKhau() {
     try {
         return createSuccessResponse(cmonPortService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
     }
    }
    //    ------------------- Danh mục vang ----------------------
    @GetMapping("/vang")
    public ResponseEntity<ResponseJson> getVang() {
        try {
            return createSuccessResponse(cmonGoldService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //    ------------------- Danh mục don vi tinh ----------------------
    @GetMapping("/donvitinh")
    public ResponseEntity<ResponseJson> getDonViTinh() {
        try {
            return createSuccessResponse(cmonDVTService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    //    ------------------- Danh mục don vi tinh ----------------------
    @GetMapping("/tiente")
    public ResponseEntity<ResponseJson> getTienTe() {
        try {
            return createSuccessResponse(cmonTienTeService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
}
