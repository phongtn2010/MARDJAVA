package com.vnsw.ws.p1.entity.json;

import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String function;
    private String fiNSWFileCode;
    private Long fiIdHoso;// Id hồ sơ
    private String fiMaHoso; //Ma ho so
    private String fiReason;// Content của lý do
    private String signedXml;//

    private String fiFileName;
    private String fiFileAttack;

    private Boolean xmlOnly;

    private Long cerType; // Loai giay chung nhan xin sua
    private String cerNo; // Loai giay chung nhan xin sua

}
