/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentList")
public class TbdAttachment04  {
    @XmlTransient
    private Long attachmentListId;
    @XmlElement(name = "AttachmentId")
    private Long attachmentId;
    @XmlElement(name = "AttachmentTypeCode")
    private Long attachmentTypeCode;
    @XmlElement(name = "AttachmentTypeName")
    private String attachmentTypeName;
    @XmlElement(name = "AttachmentName")
    private String attachmentName;
    @XmlElement(name = "LinkFile")
    private String linkfile;
    @XmlTransient
    private Long registrationProfileId;
    @XmlTransient
    private String nswfileCode;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;

    public TbdAttachment04() {
    }

    public TbdAttachment04(Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getAttachmentListId() {
        return attachmentListId;
    }

    public void setAttachmentListId(Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Long getAttachmentTypeCode() {
        return attachmentTypeCode;
    }

    public void setAttachmentTypeCode(Long attachmentTypeCode) {
        this.attachmentTypeCode = attachmentTypeCode;
    }

    public String getAttachmentTypeName() {
        return attachmentTypeName;
    }

    public void setAttachmentTypeName(String attachmentTypeName) {
        this.attachmentTypeName = attachmentTypeName;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getLinkfile() {
        return linkfile;
    }

    public void setLinkfile(String linkfile) {
        this.linkfile = linkfile;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public String getNswfileCode() {
        return nswfileCode;
    }

    public void setNswfileCode(String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    
}
