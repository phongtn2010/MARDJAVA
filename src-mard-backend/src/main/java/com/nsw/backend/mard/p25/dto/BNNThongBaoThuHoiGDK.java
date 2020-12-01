package com.nsw.backend.mard.p25.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BNNThongBaoThuHoiGDK {
    String fiNSWFileCode;
    Date fiCancelDate;
    String fiReason;
    Date fiSignConfirmDate;
    String fiSignConfirmName;
    String fiAniFeedConfirmNo;
    String fiAttachmentId;
    String fiFileName;
    String fiFileLink;
}
