package com.nsw.backend.mard.p25.client;


import lombok.Data;

import java.util.Date;

@Data
public class KetQuaXuLy {

    private String fiNSWFileCode;

    private String fiReason;

    private Long fiAttachmentId;

    private String fiFileName;

    private String fiFileLink;

    private String fiNameOfStaff;

    private String fiResponseDate;
}
