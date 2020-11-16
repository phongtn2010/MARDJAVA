package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p26.client.ResponseWrapper;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.service.TbdHoso26Service;
import com.nsw.backend.mard.p26.service.WebService26;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard/26/ws")
public class WsController extends BaseController {
    private final TbdHoso26Service tbdHoso26Service;
    private final WebService26 webService26;
    public WsController(TbdHoso26Service tbdHoso26Service, WebService26 webService26) {
        this.tbdHoso26Service = tbdHoso26Service;
        this.webService26 = webService26;
    }

    @GetMapping("/hoso/{idHS}")
    public ResponseEntity<ResponseJson> findHSById(@PathVariable int idHS) {
        TbdHoso26 result = tbdHoso26Service.findById(idHS);
        if (result == null) {
            return createErrorResponse("Thông tin hồ sơ không hợp lệ", HttpStatus.OK);
        } else {
            return createSuccessResponse(result, HttpStatus.OK);
        }
    }

    @PostMapping("/phanhoidondk")
    public ResponseEntity<ResponseJson> phanHoiDonDK(@RequestBody ResponseWrapper request) {
        ResponseJson response = webService26.phanHoiDon(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/guicv")
    public ResponseEntity<ResponseJson> bnnGuiCV(@RequestBody ResponseWrapper request) {
        ResponseJson response = webService26.tiepNhanCVMienKiem(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/thuhoicv")
    public ResponseEntity<ResponseJson> bnnThuHoiCV(@RequestBody ResponseWrapper request) {
        ResponseJson response = webService26.thuHoiCVMienKiem(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
