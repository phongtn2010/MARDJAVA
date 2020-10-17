/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p06.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p06.repositories.TbdHoso06Repository;
import com.nsw.backend.mard.p06.service.TbdHoso06Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/06/hoso")
@Profile("blameo_test")
public class Tbdhoso06DebugController extends BaseController {

    private final TbdHoso06Repository regProfileRepo;

    private final TbdHoso06Service regProfileService;

    @Autowired
    public Tbdhoso06DebugController(TbdHoso06Repository regProfileRepo, TbdHoso06Service regProfileService) {
        this.regProfileRepo = regProfileRepo;
        this.regProfileService = regProfileService;
    }

    @GetMapping("/tiepnhan")
    @Transactional
    public ResponseEntity<ResponseJson> tiepNhanHS() {
        regProfileRepo.findAllByFiHSStatusAndFiActive(Constant06.HosoStatus.CHO_TIEP_NHAN.getId(), true)
                .forEach(hoso -> regProfileService.internalStatusUpdate(hoso, Constant06.HosoStatus.DA_TIEP_NHAN.getId()));
        return createSuccessResponse("Tiếp nhận hồ sơ thành công", HttpStatus.OK);
    }

}
