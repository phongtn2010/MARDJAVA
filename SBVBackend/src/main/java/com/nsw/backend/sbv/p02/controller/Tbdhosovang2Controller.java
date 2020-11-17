
package com.nsw.backend.sbv.p02.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.sbv.p02.constant.Constant02;
import com.nsw.backend.sbv.p02.model.TbdHosovang2;
import com.nsw.backend.sbv.p02.service.TbdHosovang2Service;
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
@RequestMapping("/sbv/02/hoso")
public class Tbdhosovang2Controller extends BaseController {

        private static final Logger LOG = LoggerFactory.getLogger(Tbdhosovang2Controller.class);
        private static final String TAG = "Tbdhosovang2Controller";

    private final RabbitMQService rabbitMQService;

    private final TbdHosovang2Service regProfileService;


    @Autowired
    public Tbdhosovang2Controller(RabbitMQService rabbitMQService, TbdHosovang2Service regProfileService) {
        this.rabbitMQService = rabbitMQService;
        this.regProfileService = regProfileService;
    }

        //------------------- Create a Tbdhoso06 --------
        // ---------------------------
        @PostMapping("/")
        public ResponseEntity<ResponseJson> createHoso(@RequestBody TbdHosovang2 profile) {
            try {
                if (profile == null) {
                    return createErrorResponse("No content", HttpStatus.NO_CONTENT);
                }
                TbdHosovang2 result = saveDraftTbdhoso08(profile);
                return createSuccessResponse(result, HttpStatus.OK);
            } catch (Exception ex) {
                LOG.error(TAG + ex.getMessage(), ex);
                RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
                return createErrorResponse(ex.getMessage(), HttpStatus.OK);
            }
        }


        //-----------MISC
        private TbdHosovang2 saveDraftTbdhoso08(@RequestBody TbdHosovang2 profile) {
            String historyContent;
            if (profile.getFiIdHS() == null || profile.getFiIdTrangThai() == null) {
                profile.setFiIdTrangThai(Constant02.HosoStatus.TAO_MOI.getId());
                profile.setFiNgayTao(new Date());
                profile = regProfileService.create(profile);
                historyContent = "Tạo mới hồ sơ";
            } else {
//                profile.setFiIdTrangThai(null);
//                profile = regProfileService.update(profile);
//                historyContent = "Cập nhật hồ sơ";
            }
//            TbdLichsu06 profileHst = new TbdLichsu06();
//            profileHst.setFiIdHS(profile.getFiIdHS());
//            profileHst.setFiHSCode(profile.getFiNSWFileCode());
//            profileHst.setFiStatus(profile.getFiHSStatus());
//            profileHst.setFiSenderCode(profile.getFiCreatedBy());
//            profileHst.setFiSenderUnitName(profile.getFiImporterName());
//            profileHst.setFiSenderName(profile.getFiTaxCode());
//            profileHst.setFiContent(historyContent);
//            hstService.create(profileHst);
            return profile;
        }
    }

