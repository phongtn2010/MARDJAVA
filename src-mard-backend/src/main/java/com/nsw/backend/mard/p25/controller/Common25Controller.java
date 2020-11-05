package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.service.TbdChiTieuDG25Service;
import com.nsw.backend.mard.p25.service.TbsDanhmuc25Service;
import com.nsw.backend.mard.p25.service.TbsDonViXuLy25Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/25")
public class Common25Controller extends BaseController {
    @Autowired
    private TbsDanhmuc25Service service;

    @Autowired
    private TbsDonViXuLy25Service tbsDonViXuLy25Service;

    @Autowired
    private TbdChiTieuDG25Service tbdChiTieuDG25Service;

    @GetMapping("/chitieu/{fiNSWFileCode}")
    public ResponseEntity<ResponseJson> getByCatNo(@PathVariable String fiNSWFileCode) {
        return createSuccessResponse(tbdChiTieuDG25Service.findByFiNSWFileCode(fiNSWFileCode), HttpStatus.OK);
    }
}
