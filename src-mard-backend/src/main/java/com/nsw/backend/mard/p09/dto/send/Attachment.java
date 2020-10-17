package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;
    private Long fiAttachmentTypeCode;
    private String fiAttachmentTypeName;
    private String fiAttachmentName;
    private String fiLinkFile;
}
