/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.io.Serializable;

/**
 *
 * @author Fujitsu
 */
public class TbdAttachmentList02 implements Serializable {
    private Long attachmentListId;
    private Long fileCode;
    private String fileName;
    private String fileByte;
    private Long registrationId;
    private Long isActive;
    private Long fileTypeCode;
    private String fileTypeName;
    private String linkFile;
    private Long fileId;

    public TbdAttachmentList02() {
    }

    public TbdAttachmentList02(Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getAttachmentListId() {
        return attachmentListId;
    }

    public void setAttachmentListId(Long attachmentListId) {
        this.attachmentListId = attachmentListId;
    }

    public Long getFileCode() {
        return fileCode;
    }

    public void setFileCode(Long fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileByte() {
        return fileByte;
    }

    public void setFileByte(String fileByte) {
        this.fileByte = fileByte;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Long getFileTypeCode() {
        return fileTypeCode;
    }

    public void setFileTypeCode(Long fileTypeCode) {
        this.fileTypeCode = fileTypeCode;
    }

    public String getFileTypeName() {
        return fileTypeName;
    }

    public void setFileTypeName(String fileTypeName) {
        this.fileTypeName = fileTypeName;
    }

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

}
