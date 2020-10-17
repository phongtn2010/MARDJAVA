/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p08.model.FilterForm;
import com.nsw.backend.mard.p08.model.Tbdcvcnkd08;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import com.nsw.backend.mard.p08.repositories.Tbdcvcnkd08Repository;
import com.nsw.backend.mard.p08.repositories.Tbdcvvsty08Repository;
import com.nsw.backend.mard.p08.service.Tbdhoso08Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/mard/08/giayphep")
public class CmonGiayphep08Controller extends BaseController {
    private static final String CV_VSTY_TYPE = "vsty";
    private static final String CV_CNKD_TYPE = "cnkd";
    private static final String CV_ALL_TYPE = "all";

    private final Tbdhoso08Service tbdhoso08Service;

    private final Tbdcvvsty08Repository vetHygRepo;

    private final Tbdcvcnkd08Repository quarantineRepo;

    @Autowired
    public CmonGiayphep08Controller(Tbdhoso08Service tbdhoso08Service, Tbdcvvsty08Repository vetHygRepo, Tbdcvcnkd08Repository quarantineRepo) {
        this.tbdhoso08Service = tbdhoso08Service;
        this.vetHygRepo = vetHygRepo;
        this.quarantineRepo = quarantineRepo;
    }

    //------------------- Create a Tbdhoso10 --------
    // ---------------------------
    @GetMapping("/view")
    public ResponseEntity<ResponseJson> viewGP(
            @RequestParam("code") String fiHSCode,
            @RequestParam String type) {
        Tbdhoso08 tbdhoso08 = tbdhoso08Service.findByFiHSCode(fiHSCode);
        if (tbdhoso08 != null) {
            if (CV_VSTY_TYPE.equals(type)) {
                return createSuccessResponse(vetHygRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(fiHSCode), HttpStatus.OK);
            } else if (CV_CNKD_TYPE.equals(type)) {
                return createSuccessResponse(quarantineRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(fiHSCode), HttpStatus.OK);
            } else if (CV_ALL_TYPE.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put("vsty", vetHygRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(fiHSCode));
                map.put("cnkd", quarantineRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(fiHSCode));
                return createSuccessResponse(map, HttpStatus.OK);
            } else {
                return createErrorResponse("Loại giấy phép yêu cầu không tồn tại!", HttpStatus.OK);

            }
        } else {
            return createErrorResponse("Mã hồ sơ không tồn tại!", HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseJson> listGP(@RequestParam String fiTaxCode) {
        FilterForm ff = new FilterForm();
        ff.setFiCompanyTaxCode(fiTaxCode);
        ff.setSize(Integer.MAX_VALUE);
        List<Tbdcvcnkd08> listCNKD = new ArrayList<>();
        Date currentDate = Calendar.getInstance().getTime();
        for (Tbdhoso08 tbdhoso08 : tbdhoso08Service.searchHoso(ff).getData()) {
            if (tbdhoso08 != null) {
                Tbdcvcnkd08 license = quarantineRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(tbdhoso08.getFiHSCode());
                if (license != null &&
                        (license.getFiDispatchExpires() == null ||
                                license.getFiDispatchExpires() != null && license.getFiDispatchExpires().after(currentDate))) {
                    listCNKD.add(license);
                }
            }
        }
        return createSuccessResponse(listCNKD, HttpStatus.OK);
    }
}
