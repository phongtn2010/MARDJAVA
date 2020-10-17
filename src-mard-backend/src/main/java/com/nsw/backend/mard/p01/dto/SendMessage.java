package com.nsw.backend.mard.p01.dto;

import com.nsw.backend.mard.p01.model.Tbdhoso01;
import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String function;
    private String fiMaHoso;
    private Long fiIdHoso;// Id hồ sơ
    private String fiReason;// Content của lý do
    private String fiSignedXml;
    private String fiNSWFileCode;

    private Long cerType;
    private String cerNo;
    private String fiNguoitao;

    private String fiFileName;
    private String fiFileAttack;
    private Boolean xmlOnly;

    public static SendMessage parse(Tbdhoso01 regProfile) {
        SendMessage message = new SendMessage();
        message.setFiNguoitao(regProfile.getFiCreatedBy());
        message.setFiIdHoso(regProfile.getFiIdHS());
        message.setFiMaHoso(regProfile.getFiNSWFileCode());
        message.setFiNSWFileCode(regProfile.getFiNSWFileCode());
        return message;
    }
}
