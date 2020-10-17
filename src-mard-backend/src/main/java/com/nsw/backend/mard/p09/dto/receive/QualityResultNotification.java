package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class QualityResultNotification implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private Date fiRequestDate;
    private String fiQualityResult;
    private String fiDepartment;
    private String fiCreaterName;
    private String fiDescription;

    private List<Goods> fiGoodsList;
    private List<Attachment> fiAttachmentList;
}
