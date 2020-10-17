/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p09.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p09.repositories.TbdTbApphi09Repository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/09/apphi")
public class Tbdapphi09Controller extends BaseController {
    private final TbdTbApphi09Repository feeRepository;

    @Autowired
    public Tbdapphi09Controller(TbdTbApphi09Repository feeRepository) {
        this.feeRepository = feeRepository;
    }


    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam String fiHSCode) {
        return createSuccessResponse(feeRepository.findAllByFiNSWFileCodeOrderByFiCreatedDateAsc(fiHSCode), HttpStatus.OK);
    }
}
