package com.nsw.mard.p1.model;

import com.google.common.base.Objects;
import lombok.Data;

@Data
public class TbdAttachment01  {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDATTACHMENT01_SEQ";
    private Long fiIdAttacment;
    private boolean fiActive;
    private String fiAttachmentId;
    private Integer fiAttachmentTypeCode;
    private String fiAttachmentTypeName;
    private String fiLinkFile;
    private Long fiIdHS;
    public TbdAttachment01() {
        super();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdAttachment01 that = (TbdAttachment01) o;
        return Objects.equal(fiIdAttacment, that.fiIdAttacment);
    }
    public int hashCode() {
        return Objects.hashCode(fiIdAttacment);
    }
}
