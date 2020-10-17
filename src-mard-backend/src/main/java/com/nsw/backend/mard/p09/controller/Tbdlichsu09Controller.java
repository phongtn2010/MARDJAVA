/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p09.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p09.model.Tbdlichsu09;
import com.nsw.backend.mard.p09.service.Tbdlichsu09Service;
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
@RequestMapping("/mard/09/lichsu")
public class Tbdlichsu09Controller extends BaseController {
    private final Tbdlichsu09Service tbdlichsu09Service;

    @Autowired
    public Tbdlichsu09Controller(Tbdlichsu09Service tbdlichsu09Service) {
        this.tbdlichsu09Service = tbdlichsu09Service;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam String fiHSCode,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(tbdlichsu09Service.findByHSCode(fiHSCode), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<Tbdlichsu09> page = tbdlichsu09Service.findByHSCodeAndPagable(fiHSCode, pageRequest);
            response.setTotal(page.getTotalElements());
            response.setSuccess(true);
            response.setData(page.getContent());
            return ResponseEntity.ok(response);
        }
    }
}
