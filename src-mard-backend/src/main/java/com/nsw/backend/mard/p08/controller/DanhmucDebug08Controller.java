package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p08.repositories.Tbddvxl08Repository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/08/danhmuc")
public class DanhmucDebug08Controller extends BaseController {
    private final Tbddvxl08Repository tbddvxl08Repository;

    @Autowired
    public DanhmucDebug08Controller(Tbddvxl08Repository tbddvxl08Repository) {
        this.tbddvxl08Repository = tbddvxl08Repository;
    }

    @GetMapping("/dvxl")
    public ResponseEntity<ResponseJson> getDanhMucDVXL() {
        return createSuccessResponse(tbddvxl08Repository.findAllByFiPULevel(0), HttpStatus.OK);
    }
}
