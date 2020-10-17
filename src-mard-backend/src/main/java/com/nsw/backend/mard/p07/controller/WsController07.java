package com.nsw.backend.mard.p07.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p07.client.ResponseWrapper;
import com.nsw.backend.mard.p07.dto.RegistrationProfile;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.service.TbdHoso07Service;
import com.nsw.backend.mard.p07.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mard/07/ws")
public class WsController07 extends BaseController {

    private final TbdHoso07Service regProfileService;
    private final WsService wsService;

    @Autowired
    public WsController07(TbdHoso07Service regProfileService, WsService wsService) {
        this.regProfileService = regProfileService;

        this.wsService = wsService;
    }

    @PostMapping("/updateTrangthaiHS")
    public ResponseEntity<ResponseJson> updateTrangThaiHS(@RequestBody ResponseWrapper request) throws NSWException {
        return new ResponseEntity<>(wsService.updateHSStatus(request), HttpStatus.OK);
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable long idHS) {
        TbdHoso07 result = regProfileService.findById((int) idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            result.setFiRequestOption(result.getFiRequestOption().replace(",", ";"));
            return createSuccessResponse(RegistrationProfile.parse(result), HttpStatus.OK);
        }
    }

    @PostMapping("/updateKQTD")
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

    @PostMapping("/updateXacnhanDon")
    public ResponseEntity<ResponseJson> updateXacNhanDonDangKy(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processProfileConfirmation(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //FEE PROCESSING
    @PostMapping("/updateTBAP")
    public ResponseEntity<ResponseJson> xuLyTbApphi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processFeeNotification(request));
    }

    @PostMapping("/tbPhiBS")
    public ResponseEntity<ResponseJson> xuLyTbApphiBS(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processAdditionalFeeNotification(request));
    }

    @PostMapping("/updateXNPHI")
    public ResponseEntity<ResponseJson> xuLyXacNhanPhi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService.processFeeConfirmation(request));
    }

    //CERT PROCESSING
    @PostMapping("/updateCNVC")
    public ResponseEntity<ResponseJson> xuLyGiayVanChuyen(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processTransportResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateCNKD")
    public ResponseEntity<ResponseJson> xlGCNKiemDich(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processAnimalQuarantineResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateLohangFail")
    public ResponseEntity<ResponseJson> xlCNKDKd(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.processQuarantineFailedNotification(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateTuchoiXinsuaGCN")
    public ResponseEntity<ResponseJson> updateTuchoiXinsuaGCN(@RequestBody ResponseWrapper request) {
        ResponseJson response = wsService.processCertificateModificationRequest(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/migrate")
    public ResponseEntity<ResponseJson> migrateData(){
        wsService.migrateData();
        return ResponseEntity.ok(new ResponseJson());
    }
}
