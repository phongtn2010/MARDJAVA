package com.nsw.backend.mard.p08.dto;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
public class AttachmentFile extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;
    private Integer fiAttachmentTypeCode;
    private String fiNameOfAttachment;
    private String fiLinkFile;
}
