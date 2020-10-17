package com.nsw.backend.mard.p07.client;

import com.nsw.backend.mard.p07.model.TbdHoso07;
import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String function;
    private String fiMaHoso;
    private String fiNSWFileCode;
    private Integer fiIdHoso;// Id hồ sơ
    private String reason;// Content của lý do
    private String signedXml;

    private Long cerType;
    private String cerNo;
    private String fiNguoitao;

    private Boolean xmlOnly;

    public static SendMessage parse(TbdHoso07 regProfile) {
        SendMessage message = new SendMessage();
        message.setFiNguoitao(regProfile.getFiCreatedBy());
        message.setFiIdHoso(regProfile.getFiIdHS());
        message.setFiMaHoso(regProfile.getFiNSWFileCode());
        return message;
    }
}
