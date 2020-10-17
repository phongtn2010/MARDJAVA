package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class QuarantineFailedNotification {
    private String fiNSWFileCode;

    private Date fiRequestDate;
    private String fiQualityResult;
    private String fiDepartment;
    private String fiCreaterName;
    private String fiDescription;

    private List<Attachment> fiAttachmentList;

    public List<Attachment> getFiAttachmentList() {
        if (fiAttachmentList == null) {
            fiAttachmentList = new ArrayList<>();
        }
        return fiAttachmentList;
    }
}
