package com.nsw.mard.p04.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbdAttachment04 {
    private Long attachmentListId;
    private Long attachmentId;
    private Long attachmentTypeCode;
    private String attachmentTypeName;
    private String attachmentName;
    private String linkfile;
    private Long registrationProfileId;
    private String nswfileCode;
    private Long isActive;
    private String createBy;
    private Date createDate;
    private BigDecimal fiSize;
    private Long isRequired;

    public TbdAttachment04() {
    }

    public TbdAttachment04(final Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getAttachmentListId() {
        return this.attachmentListId;
    }

    public void setAttachmentListId(final Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(final Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Long getAttachmentTypeCode() {
        return this.attachmentTypeCode;
    }

    public void setAttachmentTypeCode(final Long attachmentTypeCode) {
        this.attachmentTypeCode = attachmentTypeCode;
    }

    public String getAttachmentTypeName() {
        return this.attachmentTypeName;
    }

    public void setAttachmentTypeName(final String attachmentTypeName) {
        this.attachmentTypeName = attachmentTypeName;
    }

    public String getAttachmentName() {
        return this.attachmentName;
    }

    public void setAttachmentName(final String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getLinkfile() {
        return this.linkfile;
    }

    public void setLinkfile(final String linkfile) {
        this.linkfile = linkfile;
    }

    public Long getRegistrationProfileId() {
        return this.registrationProfileId;
    }

    public void setRegistrationProfileId(final Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public String getNswfileCode() {
        return this.nswfileCode;
    }

    public void setNswfileCode(final String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public Long getIsActive() {
        return this.isActive;
    }

    public void setIsActive(final Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(final String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getFiSize() {
        return this.fiSize;
    }

    public void setFiSize(final BigDecimal fiSize) {
        this.fiSize = fiSize;
    }

    public Long getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Long isRequired) {
        this.isRequired = isRequired;
    }
}