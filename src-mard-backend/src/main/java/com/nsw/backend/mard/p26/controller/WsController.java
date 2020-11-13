package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.service.TbdHoso26Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/26/ws")
public class WsController extends BaseController {
    private final TbdHoso26Service tbdHoso26Service;

    public WsController(TbdHoso26Service tbdHoso26Service) {
        this.tbdHoso26Service = tbdHoso26Service;
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
}
