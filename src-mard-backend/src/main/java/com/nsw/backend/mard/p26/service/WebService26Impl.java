package com.nsw.backend.mard.p26.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p26.helper.WsServiceHelper;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.dto.SendMessage;
import com.nsw.backend.mard.p26.exception.NSWException;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.util.ResponseJson;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("webService26")
@Transactional(rollbackFor = NSWException.class)
public class WebService26Impl implements WebService26{
    private final Environment environment;
    private Gson gson;

    public WebService26Impl(Environment environment) {
        this.environment = environment;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }
    @Override
    public ResponseJson sendHoso26(TbdHoso26 tbdHoso26) {
        SendMessage message = SendMessage.parse(tbdHoso26);
        message.setType(Constant26.MessageType.TYPE_10);
        int statusUpdate=0;
        if (tbdHoso26.getFiTrangthai() == Constant26.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant26.MessageFunction.FUNC_01);
            statusUpdate=Constant26.HosoStatus.CHO_TIEP_NHAN.getId();
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant26.WebServiceURL.get(environment), message);
        return response;
    }
}
