/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p08.service.Tbdhoso08Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/08/hoso")
@Profile("blameo_test")
public class Tbdhoso08DebugController extends BaseController {

    private final
    Tbdhoso08Service tbdhoso08Service;

    @Autowired
    public Tbdhoso08DebugController(Tbdhoso08Service tbdhoso08Service) {
        this.tbdhoso08Service = tbdhoso08Service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseJson> getAllHoso() {
        return createSuccessResponse(tbdhoso08Service.findAll(), HttpStatus.OK);
    }
}
