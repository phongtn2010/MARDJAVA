/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p08.model.Tbdlichsu08;
import com.nsw.backend.mard.p08.service.Tbdlichsu08Service;
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
@RequestMapping("/mard/08/lichsu")
public class Tbdlichsu08Controller extends BaseController {
    private final Tbdlichsu08Service tbdlichsu08Service;

    @Autowired
    public Tbdlichsu08Controller(Tbdlichsu08Service tbdlichsu08Service) {
        this.tbdlichsu08Service = tbdlichsu08Service;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam String fiHSCode,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(tbdlichsu08Service.findByHSCode(fiHSCode), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<Tbdlichsu08> page = tbdlichsu08Service.findByHSCodeAndPagable(fiHSCode, pageRequest);
            response.setTotal(page.getTotalElements());
            response.setSuccess(true);
            response.setData(page.getContent());
            return ResponseEntity.ok(response);
        }
    }
}
