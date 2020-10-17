package com.nsw.backend.mard.p07.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttachmentFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;

    private String fiAttachmentTypeCode;

    private String fiNameOfAttachment;

    private String fiLinkFile;

}
