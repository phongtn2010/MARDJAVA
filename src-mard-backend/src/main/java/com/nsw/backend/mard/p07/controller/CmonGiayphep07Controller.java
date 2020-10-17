package com.nsw.backend.mard.p07.controller;


import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p07.client.*;
import com.nsw.backend.mard.p07.dto.RequestEditCer;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.model.TbdCnkdKd07;
import com.nsw.backend.mard.p07.model.TbdCvCnkd07;
import com.nsw.backend.mard.p07.model.TbdCvCnvc07;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.service.GiayCN07Service;
import com.nsw.backend.mard.p07.service.TbdHoso07Service;
import com.nsw.backend.mard.p07.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mard/07/giayphep")
public class CmonGiayphep07Controller extends BaseController {
    private static final String GIAY_VAN_CHUYEN = "gvc";
    private static final String CHUNG_NHAN_KIEM_DICH = "cnkd";
    private static final String CV_ALL = "all";
    private static final String CV_CNKD_FAIL = "cnkdkd";

    private final TbdHoso07Service regProfileService;

    private final GiayCN07Service certService;

    private final WsService wsService;

    @Autowired
    public CmonGiayphep07Controller(TbdHoso07Service regProfileService, GiayCN07Service certService, WsService wsService) {
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
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(fiHSCode);
        if (regProfile != null) {
            if (GIAY_VAN_CHUYEN.equals(type)) {
                return createSuccessResponse(getListGiayVC(regProfile), HttpStatus.OK);
            } else if (CHUNG_NHAN_KIEM_DICH.equals(type)) {
                return createSuccessResponse(getListGiayCNKD(regProfile), HttpStatus.OK);
            } else if (CV_ALL.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put(GIAY_VAN_CHUYEN, getListGiayVC(regProfile));
                map.put(CHUNG_NHAN_KIEM_DICH, getListGiayCNKD(regProfile));
                return createSuccessResponse(map, HttpStatus.OK);
            } else if (CV_CNKD_FAIL.equals(type)) {
                return createSuccessResponse(getListCvCNKDKd(regProfile), HttpStatus.OK);
            } else {
                return createErrorResponse("Loại giấy phép yêu cầu không tồn tại!", HttpStatus.OK);

            }
        } else {
            return createErrorResponse("Mã hồ sơ không tồn tại!", HttpStatus.OK);
        }
    }

    @GetMapping("/fail")
    @Profile("blameo_test")
    public ResponseEntity<ResponseJson> failTbdhoso(@RequestParam String fiNSWFileCode) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(fiNSWFileCode);
        ResponseWrapper responseWrapper = new ResponseWrapper();
        Header header = new Header();

        Subject subject = new Subject();
        subject.setReference(fiNSWFileCode);

        From from = new From();
        from.setIdentity("10902");
        from.setUnitCode(regProfile.getFiDepartmentofQuarantineCode());
        from.setName(regProfile.getFiDepartmentofQuarantineName());

        header.setSubject(subject);
        header.setFrom(from);

        responseWrapper.setHeader(header);
        QualityFail data = new QualityFail();
        data.setFiNSWFileCode(fiNSWFileCode);
        data.setFiReason("Lô hàng không đạt tiêu chuẩn");
        data.setFiSignConfirmAddress("Hà Nội");
        data.setFiSignConfirmName("Nguyễn Trường C");
        data.setFiSignConfirmDate(new Date());
        responseWrapper.setData(data);

        return ResponseEntity.ok(wsService.processQuarantineFailedNotification(responseWrapper));
    }

    @PostMapping("/request-edit")
    public ResponseEntity<ResponseJson> requestEditCer(@RequestBody RequestEditCer requestEditCer) {
        try {
            if (wsService.requestModifyCertificate(requestEditCer).isSuccess()) {
                return createSuccessResponse(certService.requestModifyCertificate(requestEditCer), HttpStatus.OK);
            } else {
                return createErrorResponse("Không gửi được yêu cầu sửa giấy phép", HttpStatus.OK);
            }
        } catch (NSWException e) {
            return createErrorResponse(e.getMessage(), HttpStatus.OK);
        }

    }

    private List<TbdCvCnvc07> getListGiayVC(TbdHoso07 regProfile) {
        return certService.findGVCByHSCode(regProfile.getFiNSWFileCode());
    }

    private List<TbdCvCnkd07> getListGiayCNKD(TbdHoso07 regProfile) {
        return certService.findGCNKDByHSCode(regProfile.getFiNSWFileCode());
    }

    private List<TbdCnkdKd07> getListCvCNKDKd(TbdHoso07 regProfile) {
        return certService.findCnkdKdByHSCode(regProfile.getFiNSWFileCode());
    }
}
