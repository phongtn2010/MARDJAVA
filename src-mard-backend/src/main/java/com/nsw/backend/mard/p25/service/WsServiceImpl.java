package com.nsw.backend.mard.p25.service;


import com.google.gson.Gson;
import com.nsw.backend.mard.p25.client.ResponseWrapper;
import com.nsw.backend.mard.p25.dto.RequestEdit;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.mard.p25.service.WsService;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public ResponseJson updateProfile(RequestEdit requestEdit) {
        return null;
    }

    @Override
    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
        return null;
    }

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
}
