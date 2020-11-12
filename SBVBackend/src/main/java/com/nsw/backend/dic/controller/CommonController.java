package com.nsw.backend.dic.controller;

import com.nsw.backend.dic.service.CmonPortService;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.sbv.p01.controller.BaseController;
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
@RequestMapping("/sbv/danhmuc")
public class CommonController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
    private static final String TAG = "CommonController";

    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    CmonPortService cmonPortService;

    //------------------- Danh mục cửa khẩu theo quốc gia ----------------------
//    @GetMapping("/cuakhau")
//    public ResponseEntity<ResponseJson> getCuaKhau() {
//        try {
//            return createSuccessResponse(CmonPortService.findAll(), HttpStatus.OK);
//        } catch (Exception ex) {
//            LOG.error(TAG + ex.getMessage(), ex);
//            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
//            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
//        }
    }
