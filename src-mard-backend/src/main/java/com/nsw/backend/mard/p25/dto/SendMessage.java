package com.nsw.backend.mard.p25.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String function;
    private String fiMaHoso;
    private String fiNSWFileCode;
    private Long fiIdHoso;// Id hồ sơ
    private String reason;// Content của lý do
    private String signedXml;

    private Long cerType;
    private String cerNo;
    private String fiNguoitao;

    private Boolean xmlOnly;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static SendMessage parse(TbdHoso25 regProfile){
        SendMessage message = new SendMessage();
        message.setFiNguoitao(regProfile.getFiCreatedBy());
        message.setFiIdHoso(regProfile.getFiIdHS().longValue());
        message.setFiMaHoso(regProfile.getFiNSWFileCode());
        return message;
    }
}
