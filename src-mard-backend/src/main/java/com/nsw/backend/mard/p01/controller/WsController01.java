package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.client.ResponseWrapper;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import com.nsw.backend.mard.p01.service.Tbdhoso01Service;
import com.nsw.backend.mard.p01.service.WsService01;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mard/01/ws")
public class WsController01 extends BaseController {

    private final Tbdhoso01Service regProfileService;
    private final WsService01 wsService01;

    @Autowired
    public WsController01(Tbdhoso01Service regProfileService, WsService01 wsService01) {
        this.regProfileService = regProfileService;
        this.wsService01 = wsService01;
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable long idHS) {
        Tbdhoso01 result = regProfileService.findById(idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(result, HttpStatus.OK);
        }
    }

    @PostMapping("/updateTrangthaiHS")
    public ResponseEntity<ResponseJson> updateTrangThaiHS(@RequestBody ResponseWrapper request) throws NSWException {
        return new ResponseEntity<>(wsService01.updateHSStatus(request), HttpStatus.OK);
    }

    @PostMapping("/xlCNKD13A")
    public ResponseEntity<ResponseJson> xlCNKD13A(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateForAnimal(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKD13B")
    public ResponseEntity<ResponseJson> xlCNKD13B(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateProductAnimal(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKDHongKongPig")
    public ResponseEntity<ResponseJson> xlCNKDHongKongPig(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateHongKongPig(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKDMalaysia")
    public ResponseEntity<ResponseJson> xlCNKDMalaysia(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateMalaysia(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKDHongKongChicken")
    public ResponseEntity<ResponseJson> xlCNKDHongKongChicken(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateHongKongChicken(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/xlCNKDChina")
    public ResponseEntity<ResponseJson> xlCNKDChina(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processCertificateChina(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 12 - 05,06
    @PostMapping("/updateKQTDhoso01")
    public ResponseEntity<ResponseJson> updateKetQuaThamDinh(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //13 - 07
    @PostMapping("/updateXacNhanDon")
    public ResponseEntity<ResponseJson> updatePheDuyetDon(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService01.processResult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateTBAP")
    public ResponseEntity<ResponseJson> xuLyTbApphi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processPhytosanitaryFee(request));
    }

    @PostMapping("/updateXNPHI")
    public ResponseEntity<ResponseJson> xuLyXacNhanPhi(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processFeeRequest(request));
    }

    //  15 - 09, 10
    @PostMapping("/updateKQXinSuaHS")
    public ResponseEntity<ResponseJson> updateKQXinSuaHS(@RequestBody ResponseWrapper request) {
        try {
            ResponseJson responseJson = wsService01.processCertificateResponseEdit(request);
            return ResponseEntity.ok(responseJson);
        } catch (NSWException ex) {
            ResponseJson responseJson = new ResponseJson();
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            return ResponseEntity.ok(responseJson);
        }
    }

    //  17 - 12, 13
    @PostMapping("/updateKQXinRutHS")
    public ResponseEntity<ResponseJson> updateKQXinRutHS(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processResponseCancel(request));
    }

    @PostMapping("/updateYCXuatKhau")
    public ResponseEntity<ResponseJson> updateYCXuatKhau(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processNotificationFailed(request));
    }

    @PostMapping("updateKQHuyCNKD")
    public ResponseEntity<ResponseJson> updateKQHuyCNKD(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processResponseCancelCer(request));
    }

    @PostMapping("updateKQXinSuaCNKD")
    public ResponseEntity<ResponseJson> updateTCYCSuaCNKD(@RequestBody ResponseWrapper request) throws NSWException {
        return ResponseEntity.ok(wsService01.processResponseEditCer(request));
    }

}
