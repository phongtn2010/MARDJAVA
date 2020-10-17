package com.nsw.backend.mard.p09.controller;


import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import com.nsw.backend.mard.p09.repositories.Tbdhoso09Repository;
import com.nsw.backend.mard.p09.service.Tbdhoso09Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/09/hoso")
@Profile("blameo_test")
public class Tbdhoso09DebugController extends BaseController {

    private final Tbdhoso09Repository regProfileRepo;

    private final Tbdhoso09Service regProfileService;

    @Autowired
    public Tbdhoso09DebugController(Tbdhoso09Repository regProfileRepo, Tbdhoso09Service regProfileService) {
        this.regProfileRepo = regProfileRepo;
        this.regProfileService = regProfileService;
    }

    @GetMapping("/testCreate-20a")
    public ResponseEntity<ResponseJson> testCreate() {
        Tbdhoso09 prototype;
        prototype = new Tbdhoso09();
        prototype.setFiHSCode("P0900001");
        prototype.setFiHSStatus(0L);
        prototype.setFiHSType(Constant09.Hoso09Type.MAU_20A.getId());
        prototype.setFiTaxCode("12344411");
//        prototype.setFiRegistrationNo("Số đăng ký!");
//        prototype.setFiImporterName("Công ty nhập khẩu");
//        prototype.setFiImporterAddress("Địa chỉ công ty");
//        prototype.setFiImporterTel("0988888888");
//        prototype.setFiImporterFax("0988888889");
//        prototype.setFiImporterEmail("test@blameo.com");
//        prototype.setFiSignedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-02"));
//        prototype.setFiSignedBy("Sếp Đào");

//        prototype = tbdhoso09Repository.save(prototype);


        return createSuccessResponse(prototype, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseJson> getAllHoso() {
        return createSuccessResponse(regProfileService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reset")
    public ResponseEntity<ResponseJson> reset() {
        regProfileRepo.deleteAll();
        return createSuccessResponse("", HttpStatus.OK);
    }

}
