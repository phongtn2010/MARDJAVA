package com.nsw.mard.p03.model;

import java.util.Date;


public class TbdDinhKem03 {

    private Long fiFileId;
    private Long id;
    private String fileCode;
    private String fileName;
    private String fileNameUpload;
    private String linkfile;
    private Long fiIdHoSo;
    private String fiMaHoSo;
    private Long isActive;
    private String createBy;
    private Date createDate;
    private String fileCodeSend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameUpload() {
        return fileNameUpload;
    }

    public void setFileNameUpload(String fileNameUpload) {
        this.fileNameUpload = fileNameUpload;
    }

    public String getLinkfile() {
        return linkfile;
    }

    public void setLinkfile(String linkfile) {
        this.linkfile = linkfile;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
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

    public Long getFiFileId() {
        return fiFileId;
    }

    public void setFiFileId(Long fiFileId) {
        this.fiFileId = fiFileId;
    }

    public String getFileCodeSend() {
        return fileCodeSend;
    }

    public void setFileCodeSend(String fileCodeSend) {
        this.fileCodeSend = fileCodeSend;
    }
}