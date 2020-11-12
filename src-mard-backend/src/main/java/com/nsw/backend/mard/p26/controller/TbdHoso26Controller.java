package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.model.FilterForm;
import com.nsw.backend.mard.p26.model.TbdHanghoa26;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.model.TbdLichsu26;
import com.nsw.backend.mard.p26.service.TbdHoso26Service;
import com.nsw.backend.mard.p26.service.TbdLichsu26Service;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/mard/26/hoso")
public class TbdHoso26Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(TbdHoso26Controller.class);
    private static final String TAG = "Tbdhoso26Controller";
    private final RabbitMQService rabbitMQService;
    private final TbdHoso26Service tbdHoso26Service;
    private final TbdLichsu26Service tbdLichsu26Service;
    @Autowired
    public TbdHoso26Controller(RabbitMQService rabbitMQService, TbdHoso26Service tbdHoso26Service, TbdLichsu26Service tbdLichsu26Service) {
        this.rabbitMQService = rabbitMQService;
        this.tbdHoso26Service = tbdHoso26Service;
        this.tbdLichsu26Service = tbdLichsu26Service;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody TbdHoso26 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHanghoa26 tbdHanghoa26 = profile.getFiProductList().get(0);
            profile.setFiHangSX(tbdHanghoa26.getFiProMadeIn());
            profile.setFiNuocSX(tbdHanghoa26.getFiProCountryName());
            TbdHoso26 result = saveDraftTbdhoso26(profile);

            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    private TbdHoso26 saveDraftTbdhoso26(@RequestBody TbdHoso26 tbdHoso26) {
        String historyContent;
        if (tbdHoso26.getFiIdHS() == null || tbdHoso26.getFiTrangthai() == null) {
            tbdHoso26.setFiTrangthai(Constant26.HosoStatus.TAO_MOI.getId());
            tbdHoso26.setFiNgaytao(new Date());
            tbdHoso26 = tbdHoso26Service.create(tbdHoso26);
            historyContent = "Tạo mới hồ sơ";
        } else {
            tbdHoso26 = tbdHoso26Service.update(tbdHoso26);
            historyContent = "Cập nhật hồ sơ";
        }
        TbdLichsu26 profileHst = new TbdLichsu26();
        profileHst.setFiIdHS(tbdHoso26.getFiIdHS());
        profileHst.setFiHSCode(tbdHoso26.getFiMaHoso());
        profileHst.setFiStatus(tbdHoso26.getFiTrangthai());
        profileHst.setFiSenderCode(tbdHoso26.getFiCreatedBy());
        profileHst.setFiSenderUnitName(tbdHoso26.getFiTenDn());
        profileHst.setFiSenderName(tbdHoso26.getFiTenDn());
        profileHst.setFiContent(historyContent);
        tbdLichsu26Service.save(profileHst);
        return tbdHoso26;
    }
    @PostMapping("/timkiem")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterForm filterForm) {
        return createSuccessResponse(tbdHoso26Service.searchHoso(filterForm), HttpStatus.OK);
    }
}
