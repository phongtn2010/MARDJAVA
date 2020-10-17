package com.vnsw.ws.p8.entity.json;

import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String function;
    private Long fiIdHoso;// Id hồ sơ
    private String fiMaHoso; //Ma ho so
    private String reason;// Content của lý do
    private String signedXml;//

    private Long cerType; // Loai giay chung nhan xin sua
    private String cerNo; // Loai giay chung nhan xin sua

    private Boolean xmlOnly;
}
