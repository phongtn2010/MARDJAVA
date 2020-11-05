package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p26.service.TbsDanhmuc26Service;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/26/danhmuc")
public class TbsDanhmuc26Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(TbsDanhmuc26Controller.class);
    private static final String TAG = "TbdDanhMuc26Controller";

    @Autowired
    private TbsDanhmuc26Service service;


    @GetMapping("/trangthai/")
    public ResponseEntity<ResponseJson> getByCatNo() {
        return createSuccessResponse(service.findByFiCatNoOrderByFiOrder(1L), HttpStatus.OK);
    }
}
