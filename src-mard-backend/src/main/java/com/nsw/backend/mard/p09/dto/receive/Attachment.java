package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;
    private Long fiAttachment;
    private String fiAttachmentTypeName;
    private String fiAttachmentName;
    private String fiLinkFile;
}
