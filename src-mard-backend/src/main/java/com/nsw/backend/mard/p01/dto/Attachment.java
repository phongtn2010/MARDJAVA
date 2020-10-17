package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;
    private Integer fiAttachmentTypeCode;
    private String fiAttachmentTypeName;
    private String fiLinkFile;
}
