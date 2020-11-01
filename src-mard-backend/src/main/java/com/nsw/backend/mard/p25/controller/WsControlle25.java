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



    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable int idHS) {
        TbdHoso25 result = regProfileService.findById(idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(Hoso25.parseToWSEntity(result), HttpStatus.OK);
        }
    }

    @PostMapping("/xacnhandon")
    public ResponseEntity<ResponseJson> updateXacNhanDon(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.xacNhanDonDK(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update-kqxl")
    public ResponseEntity<ResponseJson> updateKetQuaXL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.tiepNhanKetQuaXuLy(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/thuhoigdk")
    public ResponseEntity<ResponseJson> thuHoiGDK(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.thuHoiGDK(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/uploadkqkt")
    public ResponseEntity<ResponseJson> tccdGuiKQKT(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.tccdGuiKQKT(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/xulykq")
    public ResponseEntity<ResponseJson> guiXuLyKQ(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.guiXuLyKQ(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/giayxncl")
    public ResponseEntity<ResponseJson> guiGiayXNCL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.guiGiayXNCL(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/thuhoi-giayxncl")
    public ResponseEntity<ResponseJson> thuHoiGiayXNCL(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.thuHoiGiayXNCL(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/tiepnhan-2d")
    public ResponseEntity<ResponseJson> tiepNhanHS2D(@RequestBody ResponseWrapper request) throws NSWException {
        ResponseJson response = wsService.tiepNhanHS2D(request);
        return ResponseEntity.ok(response);
    }
}
