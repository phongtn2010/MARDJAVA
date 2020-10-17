package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.repositories.Tbddvxl01Repository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/01/danhmuc")
public class DanhMuc01Controller extends BaseController {

    private final Tbddvxl01Repository tbddvxl01Repository;

    @Autowired
    public DanhMuc01Controller(Tbddvxl01Repository tbddvxl01Repository) {
        this.tbddvxl01Repository = tbddvxl01Repository;
    }

    @GetMapping("/dvxl")
    public ResponseEntity<ResponseJson> getDanhMucDVXL() {
        return createSuccessResponse(tbddvxl01Repository.findAllByFiPULevel(0), HttpStatus.OK);
    }
}
