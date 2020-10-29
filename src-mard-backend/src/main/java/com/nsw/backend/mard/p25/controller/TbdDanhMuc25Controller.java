package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.service.TbsDanhmuc25Service;
import com.nsw.backend.mard.p25.service.TbsDonViXuLy25Service;
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
    private TbsDanhmuc25Service service;

    @Autowired
    private TbsDonViXuLy25Service tbsDonViXuLy25Service;

    @GetMapping("/getby-catno/{catNo}")
    public ResponseEntity<ResponseJson> getByCatNo(@PathVariable Long catNo) {
        return createSuccessResponse(service.findByFiCatNoOrderByFiOrder(catNo), HttpStatus.OK);
    }

    @GetMapping("/dvxl/{fiPuType}")
    public ResponseEntity<ResponseJson> getByCatNo(@PathVariable Integer fiPuType) {
        return createSuccessResponse(tbsDonViXuLy25Service.findByFiPUType(fiPuType), HttpStatus.OK);
    }
}
