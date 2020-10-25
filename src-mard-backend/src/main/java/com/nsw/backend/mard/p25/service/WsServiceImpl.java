package com.nsw.backend.mard.p25.service;


import com.google.gson.Gson;
import com.nsw.backend.mard.p25.client.From;
import com.nsw.backend.mard.p25.client.Header;
import com.nsw.backend.mard.p25.client.ResponseWrapper;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.helper.WsServiceHelper;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.model.TbdLichsu25;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service("wsService25")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);
    private final TbdHoso25Service regProfileService;
    private final TbdLichsu25Service hstService;

    private Gson gson;

    private final Environment environment;

    @Autowired
    public WsServiceImpl(TbdHoso25Service regProfileService, TbdLichsu25Service hstService, Environment environment) {
        this.regProfileService = regProfileService;
        this.hstService = hstService;
       // this.certService = certService;
        this.environment = environment;
    }

    @Override
    public ResponseJson sendProfile(TbdHoso25 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant25.MessageType.TYPE_10);
        if (regProfile.getFiHSStatus() == Constant25.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant25.HosoStatus.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant25.HosoStatus.BPMC_YEU_CAU_BO_SUNG_HO_SO.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_03);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            int statusYCBS = Constant25.HosoStatus.BPMC_YEU_CAU_BO_SUNG_HO_SO.getId();
            int updateStatus = Constant25.HosoStatus.CHO_TIEP_NHAN.getId();
            if (regProfile.getFiHSStatus() == statusYCBS) {
                updateStatus = Constant25.HosoStatus.CHO_TIEP_NHAN_HO_SO_GUI_BO_SUNG_THEO_BPMC.getId();
            }
            regProfile.setFiHSStatus(updateStatus);
            regProfile.setFiCreatedDate(new Date());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Gửi mới hồ sơ"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }
//
//    @Override
//    public ResponseJson updateProfile(RequestEdit requestEdit) {
//        return null;
//    }
//
//    @Override
////    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
//        return null;
//    }

    @Override
    public ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson processRequestUpdateProfileResponse(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson processRequestCancelProfileResponse(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson processQuarantineResult(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson processVeterinaryHygieneResult(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson processVeterinaryHygieneFail(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        return null;
    }
    private TbdLichsu25 createHistory(TbdHoso25 regProfile, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant25.SENDER.CODE);
        from.setUnitName(regProfile.getFiImporterName());
        from.setName(regProfile.getFiTaxCode());
        from.setIdentity(regProfile.getFiTaxCode());
        header.setFrom(from);
        return createHistory(regProfile, hstContent, header, regProfile.getFiTaxCode());
    }

    private TbdLichsu25 createHistory(TbdHoso25 regProfile, String hstContent, Header sendHeader, String exactSenderName) {
        TbdLichsu25 history = new TbdLichsu25();
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiNSWFileCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(exactSenderName);
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            //TODO: Map đến các đơn vị tương ứng
            history.setFiSenderUnitName(parseSenderUnitName(sendHeader.getFrom().getUnitCode()));
        }
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }
    private String parseSenderUnitName(String unitCode) {
        return "Cục Thú Y";
    }
}
