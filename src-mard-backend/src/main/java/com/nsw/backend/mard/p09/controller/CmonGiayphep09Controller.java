/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p09.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p09.dto.send.RequestEditCer;
import com.nsw.backend.mard.p09.model.*;
import com.nsw.backend.mard.p09.service.GiayCN09Service;
import com.nsw.backend.mard.p09.service.Tbdhoso09Service;
import com.nsw.backend.mard.p09.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mard/09/giayphep")
public class CmonGiayphep09Controller extends BaseController {
    private static final String GIAY_VAN_CHUYEN = "gvc";
    private static final String CHUNG_NHAN_KIEM_DICH = "cnkd";
    private static final String XAC_NHAN_XAC_LUONG = "xncl";
    private static final String CV_ALL = "all";
    private static final String CV_ALL_FAIL = "allnoti";
    private static final String CV_XNCL_FAIL = "tbxncl";
    private static final String CV_CNKD_FAIL = "cnkdkd";

    private final Tbdhoso09Service regProfileService;

    private final GiayCN09Service certService;

    private final WsService wsService;

    @Autowired
    public CmonGiayphep09Controller(Tbdhoso09Service regProfileService, GiayCN09Service certService, WsService wsService) {
        this.regProfileService = regProfileService;
        this.certService = certService;
        this.wsService = wsService;
    }

    //------------------- Create a Tbdhoso10 --------
    // ---------------------------
    @GetMapping("/view")
    public ResponseEntity<ResponseJson> viewGP(
            @RequestParam("code") String fiHSCode,
            @RequestParam String type) {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(fiHSCode);
        if (regProfile != null) {
            if (GIAY_VAN_CHUYEN.equals(type)) {
                return createSuccessResponse(getListGiayVC(regProfile), HttpStatus.OK);
            } else if (CHUNG_NHAN_KIEM_DICH.equals(type)) {
                return createSuccessResponse(getListGiayCNKD(regProfile), HttpStatus.OK);
            } else if (XAC_NHAN_XAC_LUONG.equals(type)) {
                return createSuccessResponse(getListGiayXNCL(regProfile), HttpStatus.OK);
            } else if (CV_ALL.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put(GIAY_VAN_CHUYEN, getListGiayVC(regProfile));
                map.put(CHUNG_NHAN_KIEM_DICH, getListGiayCNKD(regProfile));
                map.put(XAC_NHAN_XAC_LUONG, getListGiayXNCL(regProfile));
                return createSuccessResponse(map, HttpStatus.OK);
            } else if (CV_XNCL_FAIL.equals(type)) {
                return createSuccessResponse(getListTbXNCL(regProfile), HttpStatus.OK);
            } else if (CV_CNKD_FAIL.equals(type)) {
                return createSuccessResponse(getListCvCNKDKd(regProfile), HttpStatus.OK);
            } else if (CV_ALL_FAIL.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put(CV_XNCL_FAIL, getListTbXNCL(regProfile));
                map.put(CV_CNKD_FAIL, getListCvCNKDKd(regProfile));
                return createSuccessResponse(map, HttpStatus.OK);
            } else {
                return createErrorResponse("Loại giấy phép yêu cầu không tồn tại!", HttpStatus.OK);

            }
        } else {
            return createErrorResponse("Mã hồ sơ không tồn tại!", HttpStatus.OK);
        }
    }

    @PostMapping("/request-edit")
    public ResponseEntity<ResponseJson> requestEditCer(@RequestBody RequestEditCer requestEditCer) {
        ResponseJson response = wsService.requestModifyCertificate(requestEditCer);
        if (response.isSuccess()) {
            return createSuccessResponse(response, HttpStatus.OK);
        } else {
            return createErrorResponse("Không gửi được yêu cầu sửa giấy phép", HttpStatus.OK);
        }

    }

    private List<Tbdgiayvc09> getListGiayVC(Tbdhoso09 regProfile) {
        return certService.findGVCByHSCode(regProfile.getFiHSCode());
    }

    private List<Tbdgiaycnkd09> getListGiayCNKD(Tbdhoso09 regProfile) {
        return certService.findGCNKDByHSCode(regProfile.getFiHSCode());
    }

    private List<Tbdgiayxncl09> getListGiayXNCL(Tbdhoso09 regProfile) {
        return certService.findXNCLByHSCode(regProfile.getFiHSCode());
    }

    private List<TbdTbXncl09> getListTbXNCL(Tbdhoso09 regProfile) {
        return certService.findTbXNCLByHSCode(regProfile.getFiHSCode());
    }

    private List<TbdCnkdKd09> getListCvCNKDKd(Tbdhoso09 regProfile) {
        return certService.findCnkdKdByHSCode(regProfile.getFiHSCode());
    }
}
