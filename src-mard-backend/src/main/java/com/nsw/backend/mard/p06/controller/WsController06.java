package com.nsw.backend.mard.p06.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p06.client.ResponseWrapper;
import com.nsw.backend.mard.p06.dto.RegistrationProfile;
import com.nsw.backend.mard.p06.exception.NSWException;
import com.nsw.backend.mard.p06.model.TbdHoso06;
import com.nsw.backend.mard.p06.service.TbdHoso06Service;
import com.nsw.backend.mard.p06.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mard/06/ws")
public class WsController06 extends BaseController {

    private final TbdHoso06Service regProfileService;
    private final WsService wsService;

    @Autowired
    public WsController06(TbdHoso06Service regProfileService, WsService wsService) {
        this.regProfileService = regProfileService;
        this.wsService = wsService;
    }

    @PostMapping("/updateTrangthaiHS")
    public ResponseEntity<ResponseJson> updateTrangThaiHS(@RequestBody ResponseWrapper request) throws NSWException {
        return new ResponseEntity<>(wsService.updateHSStatus(request), HttpStatus.OK);
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable int idHS) {
        TbdHoso06 result = regProfileService.findById(idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(RegistrationProfile.parse(result), HttpStatus.OK);
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
