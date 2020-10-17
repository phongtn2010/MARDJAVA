package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.constant.Constant01;
import com.nsw.backend.mard.p01.repositories.Tbdhoso01Repository;
import com.nsw.backend.mard.p01.service.Tbdhoso01Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/01/hoso")
@Profile("blameo_test")
public class TbdhosoDebug01Controller extends BaseController {

    private final Tbdhoso01Service regProfileService;

    private final Tbdhoso01Repository regProfileRepo;

    @Autowired
    public TbdhosoDebug01Controller(Tbdhoso01Service regProfileService, Tbdhoso01Repository regProfileRepo) {
        this.regProfileService = regProfileService;
        this.regProfileRepo = regProfileRepo;
    }

    @GetMapping("/tiepnhan")
    @Transactional
    public ResponseEntity<ResponseJson> tiepNhanHS() {
        regProfileRepo.findAllByFiHSStatusAndFiActive((long) Constant01.Hoso01Status.CHO_TIEP_NHAN.getId(), true)
                .forEach(hoso -> regProfileService.internalStatusUpdate(hoso, Constant01.Hoso01Status.DA_TIEP_NHAN.getId()));
        return createSuccessResponse("Tiếp nhận hồ sơ thành công", HttpStatus.OK);
    }

    @GetMapping("/find-debug")
    public ResponseEntity<ResponseJson> findById(@RequestParam String nsw) {
        return createSuccessResponse(regProfileService.findByFiHSCode(nsw), HttpStatus.OK);
    }
}
