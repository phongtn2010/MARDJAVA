/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p06.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p06.model.TbdLichsu06;
import com.nsw.backend.mard.p06.service.TbdLichsu06Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/06/lichsu")
public class Tbdlichsu06Controller extends BaseController {
    private final TbdLichsu06Service hstService;

    @Autowired
    public Tbdlichsu06Controller(TbdLichsu06Service hstService) {
        this.hstService = hstService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam String fiHSCode,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(hstService.findByHSCode(fiHSCode), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<TbdLichsu06> page = hstService.findByHSCodeAndPagable(fiHSCode, pageRequest);
            response.setTotal(page.getTotalElements());
            response.setSuccess(true);
            response.setData(page.getContent());
            return ResponseEntity.ok(response);
        }
    }
}
