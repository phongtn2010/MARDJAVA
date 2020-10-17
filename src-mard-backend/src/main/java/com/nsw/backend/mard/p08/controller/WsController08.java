/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p08.client.ResponseWrapper;
import com.nsw.backend.mard.p08.dto.BaseRegProfile;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import com.nsw.backend.mard.p08.service.Tbdhoso08Service;
import com.nsw.backend.mard.p08.service.WsService08;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Dung de tuong tac voi Webservice
 */
@RestController
@RequestMapping("/mard/08/ws")
public class WsController08 extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(WsController08.class);
    private static final String TAG = "Ws08Controller";

    private final RabbitMQService rabbitMQService;

    private final Tbdhoso08Service regProfileService;

    private final WsService08 wsService;

    @Autowired
    public WsController08(RabbitMQService rabbitMQService, Tbdhoso08Service regProfileService, WsService08 wsService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
        this.wsService = wsService;
    }

    /**
     * Get thong tin ho so
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/hoso/{id}")
    public ResponseEntity<ResponseJson> getHoso(@PathVariable("id") long id) {
        Tbdhoso08 result = regProfileService.findById(id);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(BaseRegProfile.parse(result), HttpStatus.OK);
        }
    }

    /**
     * Update Ket qua tham dinh ho so
     *
     * @param updateResult
     * @param ucBuilder
     * @return
     */
    @PostMapping("/updateKetQuaThamDinh")
    public ResponseEntity<ResponseJson> updateKqtd(@RequestBody ResponseWrapper updateResult, UriComponentsBuilder ucBuilder) {
        ResponseJson response = wsService.updateKqtd(updateResult);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update ket qua xin rut ho so
     *
     * @param updateResult
     * @return
     */
    @PostMapping("/updateKQXinRutHS")
    public ResponseEntity<ResponseJson> updateKQXinRutHS(@RequestBody ResponseWrapper updateResult) {
        try {
            ResponseJson result = wsService.updateKQXinRutHS(updateResult);
            if (result != null) {
                if (result.isSuccess()) {
                    return createSuccessResponse(null, HttpStatus.OK);
                } else {
                    return createErrorResponse(result.getMessage(), HttpStatus.OK);
                }
            } else {
                return createErrorResponse(null, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/updateKQXinSuaHS")
    public ResponseEntity<ResponseJson> updateKQXinSuaHS(@RequestBody ResponseWrapper updateResult) {
        try {
            ResponseJson result = wsService.updateKQXinSuaHS(updateResult);
            if (result != null) {
                if (result.isSuccess()) {
                    return createSuccessResponse(null, HttpStatus.OK);
                } else {
                    return createErrorResponse(result.getMessage(), HttpStatus.OK);
                }
            } else {
                return createErrorResponse(null, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    /**
     * Xu ly KDNK mau 16 - Quaranine
     *
     * @return
     */
    @PostMapping("/xlCVKDNK")
    public ResponseEntity<ResponseJson> xlCVKDNK(@RequestBody ResponseWrapper request) {
        try {
            ResponseJson result = wsService.updateKDNK(request);
            if (result != null) {
                if (result.isSuccess()) {
                    return createSuccessResponse(null, HttpStatus.OK);
                } else {
                    return createErrorResponse(result.getMessage(), HttpStatus.OK);
                }
            } else {
                return createErrorResponse(null, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    /**
     * Xu ly VSTY mau 15 - VeterinaryHygiene
     *
     * @return
     */
    @PostMapping("/xlCVVSTY")
    public ResponseEntity<ResponseJson> xlMau15(@RequestBody ResponseWrapper request) {
        try {
            ResponseJson result = wsService.xlCVVSTY(request);
            if (result != null) {
                if (result.isSuccess()) {
                    return createSuccessResponse(null, HttpStatus.OK);
                } else {
                    return createErrorResponse(result.getMessage(), HttpStatus.OK);
                }
            } else {
                return createErrorResponse(null, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/xlKQVSTY")
    public ResponseEntity<ResponseJson> xlKQVSTY(@RequestBody ResponseWrapper responseWrapper) {
        try {
            ResponseJson result = wsService.updateKQVSTY(responseWrapper);
            if (result != null) {
                if (result.isSuccess()) {
                    return createSuccessResponse(result.getMessage(), HttpStatus.OK);
                } else {
                    return createErrorResponse(result.getMessage(), HttpStatus.OK);
                }
            } else {
                return createErrorResponse(null, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
}
