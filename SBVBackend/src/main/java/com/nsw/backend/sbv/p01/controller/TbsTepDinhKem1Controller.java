package com.nsw.backend.sbv.p01.controller;


import com.nsw.backend.sbv.p01.model.TbsTepDinhKem1;
import com.nsw.backend.sbv.p01.service.TbsTepDinhKem1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *
 *
 * @RestController
 * @class TbsTepDinhKem1Controller
 * Created by Nguyen Van Quang
 * 22/08/2018 13:00:07
 *
 */
@RestController
@RequestMapping("/sbv/01/tbsTepDinhKem1")
public class TbsTepDinhKem1Controller {

    @Autowired
    private TbsTepDinhKem1Service tbsTepDinhKem1Service;

    /**
     * @param tepDinhKemId - Type: Long
     * @return may can null
     */
    @GetMapping("/get/{tepDinhKemId}")
    public ResponseEntity<TbsTepDinhKem1> getTbsTepDinhKem1(@PathVariable(name = "tepDinhKemId") Long tepDinhKemId) {

        return ResponseEntity.ok(tbsTepDinhKem1Service.findOne(tepDinhKemId));
    }

    /**
     * @param loaiThuTuc - Type: String
     * @return can return null or throw exception
     */
    @GetMapping("/findByLoaiThuTuc")
    public ResponseEntity<List<TbsTepDinhKem1>> findByLoaiThuTuc(@RequestParam("loaiThuTuc") String loaiThuTuc) {

        return ResponseEntity.ok(tbsTepDinhKem1Service.findByLoaiThuTuc(loaiThuTuc));
    }

    /**
     * @param loaiThuTuc - Type: String
     * @return can return null or throw exception
     */
    @GetMapping("/findByLoaiThuTucAndLoaiTep")
    public ResponseEntity<List<TbsTepDinhKem1>> findByLoaiThuTucAndLoaiTep(@RequestParam("loaiThuTuc") String loaiThuTuc, @RequestParam("loaiTep") String loaiTep) {

        return ResponseEntity.ok(tbsTepDinhKem1Service.findByLoaiThuTucAndLoaiTep(loaiThuTuc, loaiTep));
    }

}
