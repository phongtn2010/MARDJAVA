package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbsPhannhomtacn25Service;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard/25/danhmuc")
public class TbdDanhMuc25Controller extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(TbdDanhMuc25Controller.class);
    private static final String TAG = "TbdDanhMuc25Controller";
    @Autowired
    private TbsPhannhomtacn25Service service;


    @GetMapping("/phannhomtacn")
    public ResponseEntity<ResponseJson> getDMPhanNhomTacn() {
        return createSuccessResponse(service.findAll(), HttpStatus.OK);
    }
}
