package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.client.ResponseWrapper;
import com.nsw.backend.mard.p25.dto.Hoso25;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p25.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mard/25/ws")
public class WsControlle25 extends BaseController {

    private final TbdHoso25Service regProfileService;
    private final WsService wsService;

    @Autowired
    public WsControlle25(TbdHoso25Service regProfileService, WsService wsService) {
        this.regProfileService = regProfileService;
        this.wsService = wsService;
    }

    @PostMapping("/updateTrangthaiHS")
    public ResponseEntity<ResponseJson> updateTrangThaiHS(@RequestBody ResponseWrapper request) throws NSWException {
        return new ResponseEntity<>(wsService.updateHSStatus(request), HttpStatus.OK);
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable int idHS) {
        TbdHoso25 result = regProfileService.findById(idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(Hoso25.parseToWSEntity(result), HttpStatus.OK);
        }
    }

    @PostMapping("/updateKetQuaThamDinh")
    public ResponseEntity<ResponseJson> updateKetQuaThamDinh(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processProfileRegisterResponse(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateKQXinSuaHS")
    public ResponseEntity<ResponseJson> updateKetQuaYCS(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processRequestUpdateProfileResponse(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateKQXinRutHS")
    public ResponseEntity<ResponseJson> updateKetQuaYCR(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processRequestCancelProfileResponse(request);
        return ResponseEntity.ok(response);
    }

    //CERT PROCESSING

    @PostMapping("/updateVSTY")
    public ResponseEntity<ResponseJson> xuLyVSTY(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processVeterinaryHygieneResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateKDNK")
    public ResponseEntity<ResponseJson> xulyKDNK(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processQuarantineResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateKQVSTY")
    public ResponseEntity<ResponseJson> xlFailXNCL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processVeterinaryHygieneFail(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
