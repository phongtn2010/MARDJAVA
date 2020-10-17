package com.nsw.backend.mard.p09.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p09.client.ResponseWrapper;
import com.nsw.backend.mard.p09.dto.send.RegistrationProfile;
import com.nsw.backend.mard.p09.exception.NSWException;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import com.nsw.backend.mard.p09.service.Tbdhoso09Service;
import com.nsw.backend.mard.p09.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mard/09/ws")
public class WsController09 extends BaseController {

    private final Tbdhoso09Service regProfileService;
    private final WsService wsService;

    @Autowired
    public WsController09(Tbdhoso09Service regProfileService, WsService wsService) {
        this.regProfileService = regProfileService;
        this.wsService = wsService;
    }

    @PostMapping("/updateTrangthaiHS")
    public ResponseEntity<ResponseJson> updateTrangThaiHS(@RequestBody ResponseWrapper request) throws NSWException {
        return new ResponseEntity<>(wsService.updateHSStatus(request), HttpStatus.OK);
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable long idHS) {
        Tbdhoso09 result = regProfileService.findById(idHS);
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

    @PostMapping("/updateXacNhanDonDangKy")
    public ResponseEntity<ResponseJson> updateXacNhanDonDangKy(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processProfileConfirmation(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //FEE PROCESSING
    @PostMapping("/tbPhi")
    public ResponseEntity<ResponseJson> xuLyTbApphi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processFeeNotification(request));
    }

    @PostMapping("/tbPhiBS")
    public ResponseEntity<ResponseJson> xuLyTbApphiBS(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processAdditionalFeeNotification(request));
    }

    @PostMapping("/xnPhi")
    public ResponseEntity<ResponseJson> xuLyXacNhanPhi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processFeeConfirmation(request));
    }
    //CERT PROCESSING

    @PostMapping("/xlGVC")
    public ResponseEntity<ResponseJson> xuLyGiayVanChuyen(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processTransportResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKD")
    public ResponseEntity<ResponseJson> xlGCNKiemDich(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processAnimalQuarantineResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlXNCL")
    public ResponseEntity<ResponseJson> xlXNCL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processQualityResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlFailXNCL")
    public ResponseEntity<ResponseJson> xlFailXNCL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processQualityResultNotification(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKDKd")
    public ResponseEntity<ResponseJson> xlCNKDKd(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processQuarantineFailedNotification(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateTuchoiXinsuaGCN")
    public ResponseEntity<ResponseJson> updateTuchoiXinsuaGCN(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processCertificateModificationRequest(request);
        return ResponseEntity.ok(response);
    }
}
