package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.model.Tbdcvkqfail01;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import com.nsw.backend.mard.p01.service.GiayCN01Service;
import com.nsw.backend.mard.p01.service.Tbdhoso01Service;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mard/01/giayphep")
public class License01Controller extends BaseController {
    private static final String CNKD_13A = "13a";
    private static final String CNKD_13B = "13b";
    private static final String CNKD_CN = "cn";
    private static final String CNKD_HKC = "hkc";
    private static final String CNKD_HKP = "hkp";
    private static final String CNKD_M = "m";
    private static final String CV_ALL = "all";

    private final GiayCN01Service certService;

    private final Tbdhoso01Service regProfileService;

    @Autowired
    public License01Controller(GiayCN01Service certService, Tbdhoso01Service regProfileService) {
        this.certService = certService;
        this.regProfileService = regProfileService;
    }

    @GetMapping("/view")
    public ResponseEntity<ResponseJson> viewGP(
            @RequestParam("code") String fiNSWFileCode,
            @RequestParam String type) {
        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
        if (regProfile != null) {
            if (CNKD_13A.equals(type)) {
                return createSuccessResponse(certService.findGCN13A(regProfile), HttpStatus.OK);
            } else if (CNKD_13B.equals(type)) {
                return createSuccessResponse(certService.findGCN13B(regProfile), HttpStatus.OK);
            } else if (CNKD_HKC.equals(type)) {
                return createSuccessResponse(certService.findGCNHKC(regProfile), HttpStatus.OK);
            } else if (CNKD_HKP.equals(type)) {
                return createSuccessResponse(certService.findGCNHKP(regProfile), HttpStatus.OK);
            } else if (CNKD_CN.equals(type)) {
                return createSuccessResponse(certService.findGCNCN(regProfile), HttpStatus.OK);
            } else if (CNKD_M.equals(type)) {
                return createSuccessResponse(certService.findGCNM(regProfile), HttpStatus.OK);
            } else if (CV_ALL.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put(CNKD_13A, certService.findGCN13A(regProfile));
                map.put(CNKD_13B, certService.findGCN13B(regProfile));
                map.put(CNKD_CN, certService.findGCNCN(regProfile));
                map.put(CNKD_HKC, certService.findGCNHKC(regProfile));
                map.put(CNKD_HKP, certService.findGCNHKP(regProfile));
                map.put(CNKD_M, certService.findGCNM(regProfile));
                return createSuccessResponse(map, HttpStatus.OK);
            } else {
                return createErrorResponse("Loại giấy phép yêu cầu không tồn tại!", HttpStatus.OK);

            }
        } else {
            return createErrorResponse("Mã hồ sơ không tồn tại!", HttpStatus.OK);
        }
    }

    @GetMapping("/tbKdYcxk")
    public ResponseEntity<ResponseJson> viewFailedNotifications(
            @RequestParam String fiNSWFileCode,
            @RequestParam(required = false, defaultValue = "0") int content) {
        Tbdcvkqfail01 result = certService.findFailExportRequest(fiNSWFileCode).orElse(null);
        if (result != null && content == 0) {
            result.setFileAvailable(!StringUtils.isEmpty(result.getFiDispatchFile()));
            result.setFiDispatchFile(null);
        }
        return createSuccessResponse(certService.findFailExportRequest(fiNSWFileCode).orElse(null), HttpStatus.OK);
    }
}